package ant.vit.publications.tools

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import ant.vit.publications.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import io.reactivex.Single

/**
 * Created by Vitiello Antonio
 */

fun <T> Single<T>.manageLoading(showProgressLiveData: MutableLiveData<SingleEvent<Boolean>>): Single<T> {
    return compose { upstream ->
        upstream
            .doOnSubscribe {
                showProgressLiveData.postValue(SingleEvent(true))
            }
            .doOnDispose {
                showProgressLiveData.postValue(SingleEvent(false))
            }
            .doOnError {
                showProgressLiveData.postValue(SingleEvent(false))
            }
            .doOnSuccess {
                showProgressLiveData.postValue(SingleEvent(false))
            }
    }
}

fun ImageView.loadImage(imageUrl: String?) {
    Picasso.get()
        .load(imageUrl)
        .fit()
        .placeholder(R.drawable.ic_placeholder)
        .error(R.drawable.ic_broken_image)
        .into(this, object : Callback {
            override fun onSuccess() {
                Log.d("AndroidExtensions", "Image loaded: $imageUrl")
            }

            override fun onError(exc: Exception) {
                Log.e("AndroidExtensions", "Error while loading image: $imageUrl", exc)
            }
        })
}


