package uiwidgetsc.recyclerviewandadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityNestedRecylerViewMainTitleBinding
import java.util.ArrayList

class NestedTitleAdapter(
    private val context: Context,
    private var mlist: ArrayList<DataClass>
): RecyclerView.Adapter<NestedTitleAdapter.TitleViewHolder>() {

    private var list: List<String> = ArrayList()
    private lateinit var binding: ActivityNestedRecylerViewMainTitleBinding

    inner class TitleViewHolder(val binding: ActivityNestedRecylerViewMainTitleBinding): RecyclerView.ViewHolder(binding.root) {
        val linearLayout: LinearLayout = binding.linearLayout
        val expandableLayout: RelativeLayout = binding.expandableLayout
        val mTextView: TextView = binding.recyclermaintitle
        val mArrowImage: ImageView = binding.arrowImage
        val nestedRecyclerView: RecyclerView = binding.childRv
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NestedTitleAdapter.TitleViewHolder {
        binding = ActivityNestedRecylerViewMainTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TitleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NestedTitleAdapter.TitleViewHolder, position: Int) {
        val model: DataClass = mlist[position]
        holder.mTextView.text = model.getItemText()

        val isExpandable = model.isExpandable()
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        if (isExpandable) {
            holder.mArrowImage.setImageResource(R.drawable.ic_baseline_arrow_upward_24)
        } else {
            holder.mArrowImage.setImageResource(R.drawable.ic_baseline_arrow_downward_24)
        }

        val subTitleAdapter = NestedSubTitleAdapter(list)
        holder.nestedRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context)
        holder.nestedRecyclerView.setHasFixedSize(true)
        holder.nestedRecyclerView.adapter = subTitleAdapter
        holder.linearLayout.setOnClickListener {
            model.setExpandable(!model.isExpandable())
            list = model.getNestedList()
            notifyItemChanged(holder.adapterPosition)
        }
    }

    override fun getItemCount(): Int = mlist.size

}

