package ant.vit.publications.network.dto.issues


import com.fasterxml.jackson.annotation.JsonProperty

data class IssueResponse(
    @JsonProperty("data")
    val data: Data?,
    @JsonProperty("error")
    val error: Boolean?,
    @JsonProperty("method")
    val method: String?
)