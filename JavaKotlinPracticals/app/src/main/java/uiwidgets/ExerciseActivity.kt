package uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityAndroidDindexBinding
import com.example.javakotlinpracticals.databinding.ActivityExerciseBinding
import uiwidgetd.activity.intent.fragment.AndroidDIndex
import uiwidgetsc.recyclerviewandadapters.Index
import uiwidgetse.otherimportantviews.AndroidEIndex
import uiwidgetse.otherimportantviews.ListViewSearch

class ExerciseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.uiWidgetsA.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.uiWidgetsB.setOnClickListener {
            startActivity(Intent(this, LayoutsMain::class.java))
        }
        binding.uiWidgetsC.setOnClickListener {
            startActivity(Intent(this, Index::class.java))
        }
        binding.uiWidgetsD.setOnClickListener {
            startActivity(Intent(this, AndroidDIndex::class.java))
        }
        binding.uiWidgetsE.setOnClickListener {
            startActivity(Intent(this, AndroidEIndex::class.java))
        }
    }

}