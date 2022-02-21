package uiwidgetsc.recyclerviewandadapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityCustomListViewBinding

class CustomListView : AppCompatActivity() {

    private lateinit var binding: ActivityCustomListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData()
    }

    private fun setUpData() {
        binding.listview.adapter = CustomListViewAdapter(this, Data.getPersonData())
        binding.listview.setOnItemClickListener { adapterView, view, pos, l ->
            val i = Intent(this, PersonActivity::class.java)
            val data = Data.getPersonData()[pos]
            i.putExtra("Image", data.personimg)
            i.putExtra("Name", data.personname)
            i.putExtra("Message", data.personmsg)
            startActivity(i)
        }
    }

}