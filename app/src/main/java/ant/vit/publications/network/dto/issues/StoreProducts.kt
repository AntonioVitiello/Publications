package ant.vit.publications.network.dto.issues


import com.fasterxml.jackson.annotation.JsonProperty

data class StoreProducts(
    @JsonProperty("appstore")
    val appstore: Appstore?,
    @JsonProperty("googleplay")
    val googleplay: Googleplay?
)