package ant.vit.publications.network.dto.publications


import com.fasterxml.jackson.annotation.JsonProperty

data class PublicationsResponse(
    @JsonProperty("data")
    val data: Data?,
    @JsonProperty("error")
    val error: Boolean?,
    @JsonProperty("method")
    val method: String?
)