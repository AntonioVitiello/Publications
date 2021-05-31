package ant.vit.publications.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ant.vit.publications.R

class BlankFragment : Fragment() {
    // Get a reference to the ViewModel scoped to its Activity
    val viewModel by activityViewModels<BlankViewModel>()
//    private lateinit var viewModel: BlankViewModel

    companion object {
        fun newInstance() = BlankFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
// Get a reference to the ViewModel scoped to its Activity
//        viewModel = ViewModelProvider(requireActivity()).get(BlankViewModel::class.java)
    }

}