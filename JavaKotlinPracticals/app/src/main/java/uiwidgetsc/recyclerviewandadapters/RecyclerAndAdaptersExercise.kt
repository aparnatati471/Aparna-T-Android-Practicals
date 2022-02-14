package uiwidgetsc.recyclerviewandadapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityRecyclerAndAdaptersExerciseBinding

class RecyclerAndAdaptersExercise : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerAndAdaptersExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerAndAdaptersExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btCustomlistview.setOnClickListener {
            startActivity(Intent(this, CustomListView::class.java))
        }
        binding.btRecyclerview.setOnClickListener {
            startActivity(Intent(this, RecyclerViewCheckbox::class.java))
        }
        binding.btStraggeredrecyclerview.setOnClickListener {
            startActivity(Intent(this, StraggeredGridLayout::class.java))
        }
        binding.btViewpager.setOnClickListener {
            startActivity(Intent(this, ViewPager::class.java))
        }
        binding.btExpandablelistview.setOnClickListener {
            startActivity(Intent(this, ExpandableListView::class.java))
        }
        binding.btExpandablerecylerview.setOnClickListener {
            startActivity(Intent(this, ExpandableRecyclerView::class.java))
        }
        binding.btBottomNavigation.setOnClickListener {
            startActivity(Intent(this, BottomNavigationBar::class.java))
        }
    }

}