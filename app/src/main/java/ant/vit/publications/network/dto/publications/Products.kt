package ant.vit.publications.network.dto.publications


import com.fasterxml.jackson.annotation.JsonProperty

data class Products(
    @JsonProperty("consumable")
    val consumable: Int?,
    @JsonProperty("total")
    val total: Int?
)