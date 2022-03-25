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
        RecyclerView.ViewHolder(binding.root) {
        val p_imageView: ImageView = binding.image
        val p_email: TextView = binding.email
        val p_firstName: TextView = binding.firstName
        val p_lastName: TextView = binding.lastName
    }

    override fun onBindViewHolder(holder: JsonParsingAdapter.ViewHolder, position: Int) {
        val p_Details = listUsers[position]
        Glide.with(context).load(p_Details.avatar).circleCrop().into(binding.image)
        holder.p_email.text = p_Details.email
        holder.p_firstName.text = p_Details.firstName
        holder.p_lastName.text = p_Details.lastName
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