package uiwidgetd.activity.intent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.FragmentInputBinding

class InputFragment : Fragment() {

    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnClick.setOnClickListener {
            if (savedInstanceState == null) {
                val bundle: Bundle = bundleOf("message" to binding.edtMsg.text)
                requireActivity().supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    addToBackStack("replace")
                    replace<OutputFragment>(R.id.fragment_container_view, args = bundle)
                }
            }
        }

    }

}