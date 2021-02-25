package ant.vit.publications.network.dto.publications


import com.fasterxml.jackson.annotation.JsonProperty

data class Data(
    @JsonProperty("items")
    val items: List<Item>?,
    @JsonProperty("itemsCount")
    val itemsCount: Int?,
    @JsonProperty("itemsPerPage")
    val itemsPerPage: Int?,
    @JsonProperty("itemsType")
    val itemsType: String?,
    @JsonProperty("nextPage")
    val nextPage: Any?,
    @JsonProperty("prevPage")
    val prevPage: Any?,
    @JsonProperty("startIndex")
    val startIndex: Int?,
    @JsonProperty("timestamp")
    val timestamp: Int?,
    @JsonProperty("totalItems")
    val totalItems: Int?
)