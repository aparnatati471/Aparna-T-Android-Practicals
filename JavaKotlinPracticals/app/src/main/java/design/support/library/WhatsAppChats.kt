package design.support.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.javakotlinpracticals.databinding.FragmentWhatsAppChatsBinding
import uiwidgetsc.recyclerviewandadapters.Data

class WhatsAppChats : Fragment() {

    private lateinit var binding: FragmentWhatsAppChatsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWhatsAppChatsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = WhatsAppChatsAdapter(context, Data.whatsAppChatsData())
        }
    }

}