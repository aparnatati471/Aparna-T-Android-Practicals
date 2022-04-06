package uiwidgetse.otherimportantviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.javakotlinpracticals.databinding.ActivityNestedScrollViewBinding
import uiwidgetsc.recyclerviewandadapters.Data

class NestedScrollView : AppCompatActivity() {

    private lateinit var binding: ActivityNestedScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNestedScrollViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData() {
        val nestedScrollView = binding.recyclerView
        nestedScrollView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val recyclerviewAdapter = NestedScrollViewAdapter(Data.getLanguageData())
        nestedScrollView.adapter = recyclerviewAdapter
    }

}