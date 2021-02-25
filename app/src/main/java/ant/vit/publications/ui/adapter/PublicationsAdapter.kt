package ant.vit.publications.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ant.vit.publications.R
import ant.vit.publications.model.IssueModel
import ant.vit.publications.model.PublicationModel
import ant.vit.publications.tools.loadImage
import kotlinx.android.synthetic.main.item_post.view.*

/**
 * Created by Vitiello Antonio
 */
class PublicationsAdapter(val listener: (IssueModel) -> Unit) : RecyclerView.Adapter<PublicationsAdapter.ViewHolder>() {
    private val issueModels = mutableListOf<IssueModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = issueModels.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindItem(issueModels[position])

    fun switchData(data: List<PublicationModel>?) {
        issueModels.clear()
        data?.forEach { publicationModel ->
            issueModels.addAll(publicationModel.issueModels)
        }
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(model: IssueModel) {
            with(itemView) {
                titleText.text = model.title
                postImage.loadImage(model.imageUrl)
                actionButton.text = if (model.isForSale) {
                    itemView.context.getString(R.string.label_buy)
                } else {
                    itemView.context.getString(R.string.label_download)
                }
                actionButton.setOnClickListener { listener.invoke(model) }
            }
        }

    }

}