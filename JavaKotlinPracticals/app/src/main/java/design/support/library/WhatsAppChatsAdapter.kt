package design.support.library

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.javakotlinpracticals.databinding.ChatSingleItemBinding

class WhatsAppChatsAdapter(private var context: Context, private var chatList: ArrayList<Chats>): RecyclerView.Adapter<WhatsAppChatsAdapter.ViewHolder>(){

    private lateinit var binding: ChatSingleItemBinding

    inner class ViewHolder(val binding: ChatSingleItemBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ChatSingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personDetails = chatList[position]
        Glide.with(context)
            .load(personDetails.image)
            .centerCrop()
            .apply(RequestOptions.circleCropTransform())
            .into(holder.binding.imgPerson)
        holder.binding.txtPersonName.text = personDetails.name
        holder.binding.txtPersonMsg.text = personDetails.message
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

}