package android.architecture.coroutines

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.javakotlinpracticals.databinding.CoroutineSingleItemBinding

class CoroutineApiCallingAdapter(private var listUsers: ArrayList<Data>, private var context: Context) :
    RecyclerView.Adapter<CoroutineApiCallingAdapter.ViewHolder>() {

    private lateinit var binding: CoroutineSingleItemBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoroutineApiCallingAdapter.ViewHolder {
        binding = CoroutineSingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoroutineApiCallingAdapter.ViewHolder, position: Int) {
        val p_Details = listUsers[position]
        Glide.with(context).load(p_Details.avatar).circleCrop().into(binding.image)
        holder.p_email.text = p_Details.email
        holder.p_firstName.text = p_Details.firstName
        holder.p_lastName.text = p_Details.lastName
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }

    inner class ViewHolder(
        val binding: CoroutineSingleItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        val p_imageView: ImageView = binding.image
        val p_email: TextView = binding.email
        val p_firstName: TextView = binding.firstName
        val p_lastName: TextView = binding.lastName
    }

}