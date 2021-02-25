package ant.vit.publications.network.dto.issues


import com.fasterxml.jackson.annotation.JsonProperty

data class Appstore(
    @JsonProperty("createdOn")
    val createdOn: String?,
    @JsonProperty("id")
    val id: Int?,
    @JsonProperty("priceTier")
    val priceTier: Int?,
    @JsonProperty("prices")
    val prices: List<Any>?,
    @JsonProperty("productId")
    val productId: Int?,
    @JsonProperty("storeProductId")
    val storeProductId: String?,
    @JsonProperty("storeType")
    val storeType: String?,
    @JsonProperty("updatedOn")
    val updatedOn: String?
)