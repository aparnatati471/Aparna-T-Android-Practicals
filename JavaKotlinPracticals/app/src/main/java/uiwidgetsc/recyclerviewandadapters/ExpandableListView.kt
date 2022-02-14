package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityExpandableListViewBinding

class ExpandableListView: AppCompatActivity() {

    private lateinit var binding: ActivityExpandableListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpandableListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData()
    }

    private fun setUpData() {
        val expandableListView = binding.simpleExpandableListView
        val adapter = ExpandableListViewAdapter(this, Data.getMoviesData(this))
        expandableListView.setAdapter(adapter)
    }

}
