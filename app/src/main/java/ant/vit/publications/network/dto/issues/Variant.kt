package ant.vit.publications.network.dto.issues


import com.fasterxml.jackson.annotation.JsonProperty

data class Variant(
    @JsonProperty("aspectRatio")
    val aspectRatio: Double?,
    @JsonProperty("default")
    val default: Boolean?,
    @JsonProperty("deletedOn")
    val deletedOn: Any?,
    @JsonProperty("hasHtml")
    val hasHtml: Boolean?,
    @JsonProperty("hasPreview")
    val hasPreview: Boolean?,
    @JsonProperty("htmlUrl")
    val htmlUrl: Any?,
    @JsonProperty("imagesUrl")
    val imagesUrl: String?,
    @JsonProperty("issueUniqueId")
    val issueUniqueId: Int?,
    @JsonProperty("mediumImagesUrl")
    val mediumImagesUrl: String?,
    @JsonProperty("metadataModifiedOn")
    val metadataModifiedOn: String?,
    @JsonProperty("metadataUrl")
    val metadataUrl: String?,
    @JsonProperty("narrowDimension")
    val narrowDimension: Int?,
    @JsonProperty("numberOfPages")
    val numberOfPages: Int?,
    @JsonProperty("platform")
    val platform: String?,
    @JsonProperty("previewPages")
    val previewPages: List<Any>?,
    @JsonProperty("propertiesJson")
    val propertiesJson: String?,
    @JsonProperty("smallImagesUrl")
    val smallImagesUrl: String?,
    @JsonProperty("status")
    val status: String?,
    @JsonProperty("tableOfContents")
    val tableOfContents: Any?,
    @JsonProperty("tags")
    val tags: List<Any>?,
    @JsonProperty("thumbnailsUrl")
    val thumbnailsUrl: String?,
    @JsonProperty("type")
    val type: String?,
    @JsonProperty("uploadFilename")
    val uploadFilename: String?,
    @JsonProperty("uploadedOn")
    val uploadedOn: String?,
    @JsonProperty("variantId")
    val variantId: Int?,
    @JsonProperty("wideDimension")
    val wideDimension: Int?
)