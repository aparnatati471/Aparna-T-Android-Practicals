package uiwidgetsc.recyclerviewandadapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ListItemBinding

class CustomListViewAdapter(
    private val context: Activity,
    private val arrayList: ArrayList<Person>
): ArrayAdapter<Person>(context, R.layout.list_item, arrayList) {

    @SuppressLint("InflateParams", "ViewHolder")
    private lateinit var binding: ListItemBinding

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        binding = ListItemBinding.inflate(context.layoutInflater, convertView as ViewGroup?, false)
     //   binding.imageview.setImageResource(arrayList[position].personimg)
        binding.pname.text = arrayList[position].personname
        binding.pmsg.text = arrayList[position].personmsg
        return binding.root
    }

}

