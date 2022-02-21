package uiwidgetd.activity.intent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.javakotlinpracticals.databinding.FragmentSendMessageBinding

class SendMessage : Fragment() {

    private lateinit var binding: FragmentSendMessageBinding
    private lateinit var mainViewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSendMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity())[MyViewModel::class.java]

        mainViewModel.edittextMsg.observe(this, Observer {
            binding.txtAdd.text = it
        })

        binding.floatSend.setOnClickListener {
            mainViewModel.updateEditTextData(binding.edtMsg.text.toString())
        }
    }

}