package uiwidgetsc.recyclerviewandadapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityIndexBinding

class Index : AppCompatActivity() {

    private lateinit var binding: ActivityIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btSimplelistview.setOnClickListener {
            startActivity(Intent(this, SimpleListView::class.java))
        }
        binding.btNestedexpandablerecylerview.setOnClickListener {
            startActivity(Intent(this, NestedRecyclerView::class.java))
        }
        binding.btExercise.setOnClickListener {
            startActivity(Intent(this, RecyclerAndAdaptersExercise::class.java))
        }
    }

}