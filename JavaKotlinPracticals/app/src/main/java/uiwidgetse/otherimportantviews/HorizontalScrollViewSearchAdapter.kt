package uiwidgetse.otherimportantviews

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.javakotlinpracticals.databinding.HorizontalSingleItemBinding

class HorizontalScrollViewSearchAdapter(private var recyclerViewCheckboxPersonModelList: ArrayList<Student>): RecyclerView.Adapter<HorizontalScrollViewSearchAdapter.ViewHolder>() {

    private lateinit var binding: HorizontalSingleItemBinding

    private var matchedItem: ArrayList<Student> = arrayListOf()
    private lateinit var context: Context

    init {
        matchedItem = recyclerViewCheckboxPersonModelList
    }

    inner class ViewHolder(val binding: HorizontalSingleItemBinding): RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.img
        val txtname: TextView = binding.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = HorizontalSingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personDetails = matchedItem[position]
        personDetails.img?.let { holder.imageView.setImageResource(it) }
        holder.txtname.text = personDetails.name
    }

    override fun getItemCount(): Int = matchedItem.size

    fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(char: CharSequence?): FilterResults {
                val character = char.toString().lowercase()

                matchedItem = if (character.isEmpty()) {
                    recyclerViewCheckboxPersonModelList
                } else {
                    recyclerViewCheckboxPersonModelList.filter {
                        it.name?.lowercase()?.contains(character) ?: true
                    } as ArrayList<Student>
                }
                val filterResults = FilterResults()
                filterResults.values = matchedItem
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                matchedItem = p1?.values as? ArrayList<Student> ?: recyclerViewCheckboxPersonModelList
                notifyDataSetChanged()
            }
        }
    }
}