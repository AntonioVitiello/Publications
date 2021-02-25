package ant.vit.publications.repository

import ant.vit.publications.network.NetworkProvider
import ant.vit.publications.network.dto.issues.IssueResponse
import ant.vit.publications.network.dto.publications.PublicationsResponse
import io.reactivex.Single

/**
 * Created by Vitiello Antonio
 */
object PubblicationsRepository {
    private var networkProvider = NetworkProvider()

    fun getPublicationsSingle(publicationsId: String): Single<PublicationsResponse> {
        return networkProvider.getPublicationsSingle(publicationsId)
    }

    fun getIssueSingle(publicationsId: String, issueId: String): Single<IssueResponse> {
        return networkProvider.getIssueSingle(publicationsId, issueId)
    }

}