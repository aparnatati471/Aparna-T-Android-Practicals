package dependency.injection

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.javakotlinpracticals.databinding.SinglePersonDetailBinding

class PersonDetailsAdapter(private val context: Context, private val personData: List<PersonModel>):
    RecyclerView.Adapter<PersonDetailsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SinglePersonDetailBinding): RecyclerView.ViewHolder(binding.root)

    /** Overridden Methods */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SinglePersonDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personDetails = personData[position]
        Glide.with(context)
            .load(personDetails.image)
            .centerCrop()
            .apply(RequestOptions.circleCropTransform())
            .into(holder.binding.image)
        holder.binding.name.text = personDetails.name
    }

    override fun getItemCount(): Int {
       return personData.size
    }

}