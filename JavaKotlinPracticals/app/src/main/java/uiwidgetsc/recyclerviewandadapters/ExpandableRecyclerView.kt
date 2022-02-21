package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityExpandableRecyclerViewBinding

class ExpandableRecyclerView : AppCompatActivity() {

    private lateinit var binding: ActivityExpandableRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExpandableRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpData()
    }

    private fun setUpData() {
        val adapter = ExpandableRecyclerViewAdpater(this, Data.getMoviesDataForRecyelrView(this))
        binding.exRecyclerView.adapter = adapter
    }

}

