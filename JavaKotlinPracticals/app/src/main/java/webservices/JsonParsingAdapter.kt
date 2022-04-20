package webservices

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.javakotlinpracticals.databinding.ActivityRetroRecyclerBinding

class JsonParsingAdapter(private var listUsers: List<Data>, private var context: Context) :
    RecyclerView.Adapter<JsonParsingAdapter.ViewHolder>() {

    private lateinit var binding: ActivityRetroRecyclerBinding

    inner class ViewHolder(val binding: ActivityRetroRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onBindViewHolder(holder: JsonParsingAdapter.ViewHolder, position: Int) {
        val pDetails = listUsers[position]
        Glide.with(context).load(pDetails.avatar).circleCrop().into(binding.image)
        holder.binding.email.text = pDetails.email
        holder.binding.firstName.text = pDetails.firstName
        holder.binding.lastName.text = pDetails.lastName
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JsonParsingAdapter.ViewHolder {
        binding =
            ActivityRetroRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

}