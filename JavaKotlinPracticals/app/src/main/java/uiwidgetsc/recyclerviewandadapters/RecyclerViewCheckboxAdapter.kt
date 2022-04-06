package uiwidgetsc.recyclerviewandadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.javakotlinpracticals.databinding.CustomRecyclerviewBinding

class RecyclerViewCheckboxAdapter(private var recyclerViewCheckboxPersonModelList: ArrayList<Person>): RecyclerView.Adapter<RecyclerViewCheckboxAdapter.ViewHolder>() {

    private lateinit var binding: CustomRecyclerviewBinding
    private var matchedItem: ArrayList<Person> = arrayListOf()
    private var context: Context? = null

    init {
        matchedItem = recyclerViewCheckboxPersonModelList
        context = context
    }

    inner class ViewHolder(val binding: CustomRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.image
        val txtname: TextView = binding.name
        val txtmsg: TextView = binding.msg
        val checkbox: CheckBox = binding.chkbox
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CustomRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personDetails = matchedItem[position]
        personDetails.personimg?.let { holder.imageView.setImageResource(it) }
        holder.txtname.text = personDetails.personname
        holder.txtmsg.text = personDetails.personmsg
        holder.checkbox.isChecked = false
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
                        it.personname?.lowercase()?.contains(character) ?: it.personselect
                    } as ArrayList<Person>
                }
                val filterResults = FilterResults()
                filterResults.values = matchedItem
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                matchedItem = p1?.values as? ArrayList<Person> ?: recyclerViewCheckboxPersonModelList
                notifyDataSetChanged()
            }
        }
    }

}