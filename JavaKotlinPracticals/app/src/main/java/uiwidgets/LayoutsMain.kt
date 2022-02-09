package uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityLayoutsMainBinding

class LayoutsMain : AppCompatActivity() {

    private lateinit var binding: ActivityLayoutsMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutsMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.constraintLayout.setOnClickListener {
            startActivity(Intent(this, ConstraintLayout::class.java))
        }
        binding.linearLayout.setOnClickListener {
            startActivity(Intent(this, LinearLayout::class.java))
        }
        binding.relativeLayout.setOnClickListener {
            startActivity(Intent(this, RelativeLayout::class.java))
        }
        binding.tableLayout.setOnClickListener {
            startActivity(Intent(this, TableLayout::class.java))
        }
        binding.tabLayout.setOnClickListener {
            startActivity(Intent(this, TabLayout::class.java))
        }
        binding.listview.setOnClickListener {
            startActivity(Intent(this, ListView::class.java))
        }
        binding.gridview.setOnClickListener {
            startActivity(Intent(this, GridView::class.java))
        }
        binding.framelayout.setOnClickListener {
            startActivity(Intent(this, FrameLayout::class.java))
        }
        binding.mergeinclude.setOnClickListener {
            startActivity(Intent(this, MergeAndInclude::class.java))
        }
    }

}