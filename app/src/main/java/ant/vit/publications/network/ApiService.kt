package ant.vit.publications.network

import ant.vit.publications.network.dto.issues.IssueResponse
import ant.vit.publications.network.dto.publications.PublicationsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Vitiello Antonio
 */
interface ApiService {

    //eg: https://api-ne.paperlit.com/v8/projects/prj_5df8a84c8ef9a/publications
    @GET("/v8/projects/{publicationsId}/publications")
    fun getPublicationsSingle(@Path("publicationsId") publicationsId: String): Single<PublicationsResponse>

    //eg: https://api-ne.paperlit.com/v8/projects/prj_5df8a84c8ef9a/issues/pub_5df8a84cdeb4d
    @GET("/v8/projects/{publicationsId}/issues/{issueId}")
    fun getIssueSingle(
        @Path("publicationsId") publicationsId: String,
        @Path("issueId") issueId: String
    ): Single<IssueResponse>

}