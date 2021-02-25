package ant.vit.publications.network.dto.publications


import com.fasterxml.jackson.annotation.JsonProperty

data class PropertiesJson(
    @JsonProperty("products")
    val products: Products?,
    @JsonProperty("stores")
    val stores: Stores?
)