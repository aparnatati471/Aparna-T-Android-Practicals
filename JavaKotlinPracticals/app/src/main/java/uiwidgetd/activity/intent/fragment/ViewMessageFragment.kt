package uiwidgetd.activity.intent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentResultListener
import androidx.navigation.Navigation
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.FragmentViewMessageBinding

class ViewMessageFragment : Fragment() {

    private lateinit var binding: FragmentViewMessageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewMessageBinding.inflate(inflater, container, false)
        binding.txtView.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_viewMessageFragment_to_galleryFragment)
        }

        parentFragmentManager.setFragmentResultListener("data", this, FragmentResultListener { requestKey, result ->
            val datafrom = result.getString("data")
            binding.datafromfragone.text = datafrom
        })

        return binding.root
    }

}