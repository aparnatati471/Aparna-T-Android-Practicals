package webservices

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.javakotlinpracticals.databinding.ActivityRetroRecyclerBinding

class RetrofitRecyclerViewAdapter(private var listUsers: List<Data>, private var context: Context, private val mListener: ((Int) -> Unit)) :
    RecyclerView.Adapter<RetrofitRecyclerViewAdapter.ViewHolder>() {

    private lateinit var binding: ActivityRetroRecyclerBinding

    inner class ViewHolder(
        val binding: ActivityRetroRecyclerBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                mListener(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RetrofitRecyclerViewAdapter.ViewHolder {
        binding =
            ActivityRetroRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrofitRecyclerViewAdapter.ViewHolder, position: Int) {
        val p_Details = listUsers[position]
        Glide.with(context).load(p_Details.avatar).circleCrop().into(binding.image)
        holder.binding.email.text = p_Details.email
        holder.binding.firstName.text = p_Details.firstName
        holder.binding.lastName.text = p_Details.lastName
    }

    override fun getItemCount(): Int {
        return listUsers.size
    }

}