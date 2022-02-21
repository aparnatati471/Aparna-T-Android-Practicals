package uiwidgetsc.recyclerviewandadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.javakotlinpracticals.databinding.ActivityNestedRecyclerViewSubTitleBinding

class NestedSubTitleAdapter(private val mlist: List<String>): RecyclerView.Adapter<NestedSubTitleAdapter.SubTitleViewHolder>() {

    private lateinit var binding: ActivityNestedRecyclerViewSubTitleBinding

    inner class SubTitleViewHolder(val binding: ActivityNestedRecyclerViewSubTitleBinding): RecyclerView.ViewHolder(binding.root) {
        val mChildTextView: TextView = binding.nestedItem
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NestedSubTitleAdapter.SubTitleViewHolder {
        binding = ActivityNestedRecyclerViewSubTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubTitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NestedSubTitleAdapter.SubTitleViewHolder, position: Int) {
        holder.mChildTextView.text = mlist[position]
    }

    override fun getItemCount(): Int = mlist.size

}

