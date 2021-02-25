package ant.vit.publications.network.dto.issues


import com.fasterxml.jackson.annotation.JsonProperty

data class Item(
    @JsonProperty("aspectRatio")
    val aspectRatio: Double?,
    @JsonProperty("caption")
    val caption: Any?,
    @JsonProperty("dpmId")
    val dpmId: Any?,
    @JsonProperty("isForSale")
    val isForSale: Boolean?,
    @JsonProperty("issueId")
    val issueId: String?,
    @JsonProperty("issueName")
    val issueName: String?,
    @JsonProperty("metadataModifiedOn")
    val metadataModifiedOn: String?,
    @JsonProperty("metadataUrl")
    val metadataUrl: String?,
    @JsonProperty("pdfSize")
    val pdfSize: Int?,
    @JsonProperty("pdfUrl")
    val pdfUrl: String?,
    @JsonProperty("product")
    val product: Product?,
    @JsonProperty("publicationId")
    val publicationId: String?,
    @JsonProperty("publishedOn")
    val publishedOn: String?,
    @JsonProperty("status")
    val status: String?,
    @JsonProperty("tableOfContents")
    val tableOfContents: Any?,
    @JsonProperty("thumbnailsUrl")
    val thumbnailsUrl: String?,
    @JsonProperty("type")
    val type: String?,
    @JsonProperty("uniqueId")
    val uniqueId: Int?,
    @JsonProperty("updatedOn")
    val updatedOn: String?,
    @JsonProperty("uploadedOn")
    val uploadedOn: String?,
    @JsonProperty("variants")
    val variants: List<Variant>?
)