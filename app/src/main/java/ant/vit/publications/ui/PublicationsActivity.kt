package ant.vit.publications.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ant.vit.publications.R
import ant.vit.publications.model.IssueModel
import ant.vit.publications.model.PublicationModel
import ant.vit.publications.tools.SingleEvent
import ant.vit.publications.ui.adapter.PublicationsAdapter
import ant.vit.publications.viewmodel.PublicationsViewModel
import kotlinx.android.synthetic.main.activity_load_posts.*


/**
 * Created by Vitiello Antonio
 */
class PublicationsActivity : AppCompatActivity() {
    private val mViewModel by viewModels<PublicationsViewModel>()
    private lateinit var mAdapter: PublicationsAdapter
    private val publicationsId = "prj_5df8a84c8ef9a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_posts)

        mViewModel.progressLiveData.observe(this, ::showProgress)
        mViewModel.errorLiveData.observe(this, ::showError)
        mViewModel.publicationModelsLiveData.observe(this, ::fillData)

        mViewModel.loadPublicationsById(publicationsId)

        initComponents()
    }

    private fun initComponents() {
        mAdapter = PublicationsAdapter (::showAlert)
        postRecyclerView.adapter = mAdapter

        supportActionBar?.apply {
            setDisplayShowHomeEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

    }

    private fun showAlert(issueModel: IssueModel) {
        val alertTitle = if (issueModel.isForSale) getString(R.string.label_buy) else getString(R.string.label_download)
        val alertMessage = getString(R.string.you_choose, issueModel.title)
        AlertDialog.Builder(this)
            .setTitle(alertTitle)
            .setMessage(alertMessage)
            .setPositiveButton(android.R.string.ok) { dialog, _ -> dialog.dismiss() }
            .setIcon(android.R.drawable.ic_dialog_info)
            .show()
    }

    private fun fillData(models: List<PublicationModel>) {
        mAdapter.switchData(models)
    }

    private fun showError(event: SingleEvent<String>) {
        event.getContentIfNotHandled()?.let { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }

    private fun showProgress(event: SingleEvent<Boolean>) {
        progressView.visibility = if (event.getContentIfNotHandled() == true) View.VISIBLE else View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return false
    }

}
