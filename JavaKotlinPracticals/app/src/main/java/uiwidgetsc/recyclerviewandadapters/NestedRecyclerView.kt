package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityNestedRecyclerViewBinding

class NestedRecyclerView : AppCompatActivity() {

    private lateinit var binding: ActivityNestedRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNestedRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData()
    }

    private fun setUpData() {
        val expandableRecyclerView = binding.nestedrecyclerview
        val nestedTitleAdapter = NestedTitleAdapter(this,Data.getMoviesData(this))
        expandableRecyclerView.adapter = nestedTitleAdapter
    }

}