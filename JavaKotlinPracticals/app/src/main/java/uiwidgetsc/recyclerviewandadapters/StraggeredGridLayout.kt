package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.javakotlinpracticals.databinding.ActivityStraggeredGridLayoutBinding

class StraggeredGridLayout : AppCompatActivity() {

    private lateinit var binding: ActivityStraggeredGridLayoutBinding
    private lateinit var straggeredGridLayoutManager: StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStraggeredGridLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpImages()
    }

    private fun setUpImages() {
        val photorecycler = binding.photoRecyclerView
        straggeredGridLayoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        photorecycler.layoutManager = straggeredGridLayoutManager
        photorecycler.adapter = StraggeredGridLayoutAdapter(Data.getImages())
        photorecycler.addItemDecoration(ItemDecoration(3,50, true))
    }

}