package ant.vit.publications.model

import ant.vit.publications.network.dto.publications.PublicationsResponse

/**
 * Created by Vitiello Antonio
 */
fun mapPublicationsResponse(response: PublicationsResponse): MutableList<PublicationModel> {
    return mutableListOf<PublicationModel>().apply {
        response.data?.items?.forEach { item ->
            add(PublicationModel().apply {
                id = item.publicationId
                publicationName = item.publicationName
            })
        }
    }
}

