package uiwidgetse.otherimportantviews

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.javakotlinpracticals.databinding.ActivityHorizontalScrollViewSearchBinding
import uiwidgetsc.recyclerviewandadapters.Data


class HorizontalScrollViewSearch : AppCompatActivity() {

    private lateinit var binding: ActivityHorizontalScrollViewSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalScrollViewSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getStudentList()
    }

    private fun getStudentList() {
        val recyclerviewAdapter = HorizontalScrollViewSearchAdapter(Data.getStudentData())

        val horizontalRecyclerview = binding.horizontalRecyclerView
        horizontalRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerview.adapter = recyclerviewAdapter

        val verticalRecyclerView = binding.verticalRecyclerView
        verticalRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        verticalRecyclerView.adapter = recyclerviewAdapter

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