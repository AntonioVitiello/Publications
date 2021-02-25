package ant.vit.publications.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Vitiello Antonio
 */
@Parcelize
data class PublicationModel(
    var id: String? = null,
    var publicationName: String? = null,
    var issueModels: MutableList<IssueModel> = mutableListOf()
) : Parcelable
