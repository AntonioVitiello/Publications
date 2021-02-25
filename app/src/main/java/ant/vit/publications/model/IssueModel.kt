package ant.vit.publications.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Vitiello Antonio
 */

@Parcelize
data class IssueModel(
    var id: String? = null,
    var title: String? = null,
    var imageUrl: String? = null,
    var isForSale: Boolean = false
) : Parcelable