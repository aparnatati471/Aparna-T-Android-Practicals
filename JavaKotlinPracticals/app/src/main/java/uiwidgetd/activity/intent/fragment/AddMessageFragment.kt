package uiwidgetd.activity.intent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.FragmentAddMessageBinding

class AddMessageFragment : Fragment() {

    private lateinit var binding: FragmentAddMessageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddMessageBinding.inflate(inflater, container, false)
        addMessage()
        return binding.root
    }

    private fun addMessage() {
        binding.txtAdd.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_addMessageFragment_to_viewMessageFragment)
        }
        val message = binding.edtMsg.text
        binding.floatSend.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("data", message.toString())
            parentFragmentManager.setFragmentResult("data", bundle)
            Toast.makeText(context, "Data Sent",Toast.LENGTH_SHORT).show()
        }
    }

}