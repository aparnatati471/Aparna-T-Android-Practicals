package uiwidgetse.otherimportantviews

import android.R.layout
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityListViewSearchBinding

class ListViewSearch : AppCompatActivity() {

    private lateinit var binding: ActivityListViewSearchBinding
    var adapter: ArrayAdapter<String>? = null
    var fruits = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val menuItem = menu?.findItem(R.id.search_in_actionbar)
        val searchView = menuItem?.actionView as androidx.appcompat.widget.SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (fruits.contains(query)) {
                    adapter?.filter?.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter?.filter?.filter(newText)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun setUpListView() {
        fruits = arrayListOf(
            "Apple",
            "Banana",
            "Cherry",
            "Orange",
            "Mango",
            "Grapes",
            "Avocado",
            "Watermelon",
            "Kiwi",
            "Strawberry",
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

        val listview = binding.listView
        adapter = ArrayAdapter(this, layout.simple_list_item_1, fruits)
        listview.adapter = adapter
    }

}