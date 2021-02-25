package ant.vit.publications.network.dto.publications


import com.fasterxml.jackson.annotation.JsonProperty

data class Stores(
    @JsonProperty("appStoreDefaultPriceTier")
    val appStoreDefaultPriceTier: Any?,
    @JsonProperty("googlePlayDefaultPriceTier")
    val googlePlayDefaultPriceTier: Any?
)