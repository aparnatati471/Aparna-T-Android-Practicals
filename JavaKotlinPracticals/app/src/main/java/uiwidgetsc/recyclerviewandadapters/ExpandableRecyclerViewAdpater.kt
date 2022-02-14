package uiwidgetsc.recyclerviewandadapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.javakotlinpracticals.R
import android.widget.RelativeLayout
import com.example.javakotlinpracticals.databinding.ActivityExpandableRecyclerViewExpandableItemBinding

class ExpandableRecyclerViewAdpater(
    private val context: Context,
    private val moviesData: ArrayList<MoviesItem>
): RecyclerView.Adapter<ExpandableRecyclerViewAdpater.ViewHolder>() {

    private lateinit var binding: ActivityExpandableRecyclerViewExpandableItemBinding

    class ViewHolder(val binding: ActivityExpandableRecyclerViewExpandableItemBinding): RecyclerView.ViewHolder(binding.root) {
        var movieName: TextView = binding.exRecyclerMaintitle
        var movieRealName: TextView = binding.exRealName
        var movieTeamName: TextView = binding.exTeamname
        var movieFirstApperance: TextView = binding.exFirstappearence
        var movieCreatedBy: TextView = binding.exCreatedby
        var moviePublisher: TextView = binding.exPublisher
        var movieBio: TextView = binding.exBio
        var linearLayout: LinearLayout = binding.exLinearLayout
        var expandedLayout: RelativeLayout = binding.exRelativeLayout
        var arrowImage: ImageView = binding.arrowImage
    }

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ActivityExpandableRecyclerViewExpandableItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelData: MoviesItem = moviesData[position]
        holder.movieName.text = modelData.name
        holder.movieRealName.text = modelData.realname
        holder.movieTeamName.text = modelData.team
        holder.movieFirstApperance.text = modelData.firstappearance
        holder.movieCreatedBy.text = modelData.createdby
        holder.moviePublisher.text = modelData.publisher
        holder.movieBio.text = modelData.bio

        val isExpandable: Boolean = moviesData[position].expandable
        holder.expandedLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        if (isExpandable) {
            holder.arrowImage.setImageResource(R.drawable.ic_baseline_arrow_upward_24)
        } else {
            holder.arrowImage.setImageResource(R.drawable.ic_baseline_arrow_downward_24)
        }

        holder.arrowImage.setOnClickListener {
            val version = moviesData[position]
            version.expandable = !modelData.expandable
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = moviesData.size

}

