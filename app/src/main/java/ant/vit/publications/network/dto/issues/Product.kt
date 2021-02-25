package ant.vit.publications.network.dto.issues


import com.fasterxml.jackson.annotation.JsonProperty

data class Product(
    @JsonProperty("createdOn")
    val createdOn: String?,
    @JsonProperty("deletedOn")
    val deletedOn: Any?,
    @JsonProperty("description")
    val description: Any?,
    @JsonProperty("generated")
    val generated: String?,
    @JsonProperty("isHidden")
    val isHidden: Boolean?,
    @JsonProperty("productId")
    val productId: Int?,
    @JsonProperty("projectId")
    val projectId: String?,
    @JsonProperty("sortingPosition")
    val sortingPosition: Any?,
    @JsonProperty("storeProducts")
    val storeProducts: StoreProducts?,
    @JsonProperty("title")
    val title: String?,
    @JsonProperty("type")
    val type: String?,
    @JsonProperty("updatedOn")
    val updatedOn: String?,
    @JsonProperty("validOn")
    val validOn: ValidOn?
)