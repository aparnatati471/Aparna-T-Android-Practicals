package uiwidgetsc.recyclerviewandadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.javakotlinpracticals.databinding.CustomStraggeredGridLayoutBinding

class StraggeredGridLayoutAdapter(var photoList: ArrayList<StraggeredPhotosModel>): RecyclerView.Adapter<StraggeredGridLayoutAdapter.ViewHolder>() {

    private lateinit var binding: CustomStraggeredGridLayoutBinding

    inner class ViewHolder(val binding: CustomStraggeredGridLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.imageViewForGrid
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        binding = CustomStraggeredGridLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = photoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(photoList[position].photo)
    }

}

