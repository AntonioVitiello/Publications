package ant.vit.publications.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ant.vit.publications.R
import ant.vit.publications.model.IssueModel
import ant.vit.publications.model.PublicationModel
import ant.vit.publications.model.mapPublicationsResponse
import ant.vit.publications.network.dto.issues.IssueResponse
import ant.vit.publications.repository.PubblicationsRepository
import ant.vit.publications.tools.SingleEvent
import ant.vit.publications.tools.manageLoading
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Vitiello Antonio
 */
class PublicationsViewModel(application: Application) : AndroidViewModel(application) {
    private val compositeDisposable = CompositeDisposable()
    var publicationModelsLiveData = MutableLiveData<MutableList<PublicationModel>>()
    var errorLiveData: MutableLiveData<SingleEvent<String>> = MutableLiveData()
    var progressLiveData: MutableLiveData<SingleEvent<Boolean>> = MutableLiveData()

    companion object {
        private const val TAG = "PublicationsViewModel"
    }

    fun loadPublicationsById(publicationsId: String) {
        compositeDisposable.add(
            PubblicationsRepository.getPublicationsSingle(publicationsId)
                .flatMap { publications ->
                    val publicationsModels = mapPublicationsResponse(publications)
                    val issueSingleList = publicationsModels.map { publicationModel ->
                        publicationModel.id?.let { itemPublicationId ->
                            PubblicationsRepository.getIssueSingle(publicationsId, itemPublicationId)
                                .onErrorReturn { IssueResponse(null, true, null) }
                        }
                    }
                    Single.zip(issueSingleList) { issueResponses ->
                        issueResponses.forEachIndexed { i, response ->
                            val issueResponse = response as IssueResponse
                            issueResponse.data?.items?.forEach { issueItem ->
                                val imageUrl = issueItem.variants?.get(0)?.imagesUrl?.replace("{0:000}", "001")
                                val issueModel =
                                    IssueModel(issueItem.publicationId, issueItem.issueName, imageUrl, issueItem.isForSale == true)
                                publicationsModels[i].issueModels.add(issueModel)
                            }
                        }
                        publicationsModels
                    }
                }
                .manageLoading(progressLiveData)
                .subscribeOn(Schedulers.io())
                //.observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    publicationModelsLiveData.postValue(it)
                }, {
                    val message = getApplication<Application>().getString(R.string.generic_network_error_message)
                    errorLiveData.value = SingleEvent(message)
                    Log.e(TAG, "Error while loading publications by id.", it)
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
    }

}