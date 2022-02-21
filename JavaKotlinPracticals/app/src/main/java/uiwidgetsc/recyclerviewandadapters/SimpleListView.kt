package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.javakotlinpracticals.databinding.ActivitySimpleListViewBinding

class SimpleListView : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListView()
        itemClickEvent()
    }

    private fun itemClickEvent() {
        binding.listOfFruits.setOnItemClickListener { adapterView, view, pos, l ->
            val selectedItem = adapterView.getItemAtPosition(pos)
            Toast.makeText(this, selectedItem.toString(), Toast.LENGTH_LONG).show()
        }
    }

    private fun setUpListView() {
        val listview = binding.listOfFruits
        val fruits = arrayOf(
            "Apple",
            "Banana",
            "Cherry",
            "Orange",
            "Mango",
            "Grapes",
            "Avocado",
            "Watermelon",
            "Kiwi",
            "Strawberry"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, fruits)
        listview.adapter = adapter
    }

}