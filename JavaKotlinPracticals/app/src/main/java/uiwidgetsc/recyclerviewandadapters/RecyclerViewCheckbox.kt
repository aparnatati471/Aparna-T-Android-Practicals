package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.javakotlinpracticals.databinding.ActivityRecyclerViewCheckboxBinding

class RecyclerViewCheckbox : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewCheckboxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewCheckboxBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPersonList()
    }

    private fun getPersonList(){
        val recyclerview = binding.recyclerView
        val recyclerviewAdapter = RecyclerViewCheckboxAdapter(Data.getPersonData())
        recyclerview.adapter = recyclerviewAdapter

        recyclerview.layoutManager = object : LinearLayoutManager(applicationContext) {
            override fun canScrollVertically(): Boolean = false
        }

        binding.search.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                recyclerviewAdapter.getFilter().filter(newText)
                return true
            }
        })
    }

}

