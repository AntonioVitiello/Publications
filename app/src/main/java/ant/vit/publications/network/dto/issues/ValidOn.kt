package ant.vit.publications.network.dto.issues


import com.fasterxml.jackson.annotation.JsonProperty

data class ValidOn(
    @JsonProperty("issueId")
    val issueId: String?,
    @JsonProperty("publicationId")
    val publicationId: String?
)