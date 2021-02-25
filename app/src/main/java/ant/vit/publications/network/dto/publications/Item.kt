package ant.vit.publications.network.dto.publications


import com.fasterxml.jackson.annotation.JsonProperty

data class Item(
    @JsonProperty("autoPublish")
    val autoPublish: Boolean?,
    @JsonProperty("createdOn")
    val createdOn: String?,
    @JsonProperty("deletedOn")
    val deletedOn: Any?,
    @JsonProperty("description")
    val description: Any?,
    @JsonProperty("maxNumberOfIssues")
    val maxNumberOfIssues: Int?,
    @JsonProperty("projectId")
    val projectId: String?,
    @JsonProperty("propertiesJson")
    val propertiesJson: PropertiesJson?,
    @JsonProperty("publicationId")
    val publicationId: String?,
    @JsonProperty("publicationName")
    val publicationName: String?,
    @JsonProperty("readersEmail")
    val readersEmail: Any?,
    @JsonProperty("sortingPosition")
    val sortingPosition: Any?,
    @JsonProperty("storageLocation")
    val storageLocation: String?,
    @JsonProperty("supportEmail")
    val supportEmail: Any?,
    @JsonProperty("updatedOn")
    val updatedOn: String?
)