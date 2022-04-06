package uiwidgetse.otherimportantviews

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.javakotlinpracticals.databinding.NestedSingleItemBinding

class NestedScrollViewAdapter(private var dataList: ArrayList<Student>): RecyclerView.Adapter<NestedScrollViewAdapter.ViewHolder>() {

    private lateinit var binding: NestedSingleItemBinding

    inner class ViewHolder(val binding: NestedSingleItemBinding): RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.img
        val txtname: TextView = binding.name
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NestedScrollViewAdapter.ViewHolder {
        binding = NestedSingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NestedScrollViewAdapter.ViewHolder, position: Int) {
        val personDetails = dataList[position]
        personDetails.img?.let { holder.imageView.setImageResource(it) }
        holder.txtname.text = personDetails.name
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

}