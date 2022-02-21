package uiwidgetsc.recyclerviewandadapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.javakotlinpracticals.databinding.CustomRecyclerviewBinding

class RecyclerViewCheckboxAdapter(private var recyclerViewCheckboxPersonModelList: ArrayList<Person>): RecyclerView.Adapter<RecyclerViewCheckboxAdapter.ViewHolder>() {

    private lateinit var binding: CustomRecyclerviewBinding

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
        val personDetails = recyclerViewCheckboxPersonModelList[position]
        holder.imageView.setImageResource(personDetails.personimg)
        holder.txtname.text = personDetails.personname
        holder.txtmsg.text = personDetails.personmsg
        holder.checkbox.isChecked = false
    }

    override fun getItemCount(): Int = recyclerViewCheckboxPersonModelList.size

}