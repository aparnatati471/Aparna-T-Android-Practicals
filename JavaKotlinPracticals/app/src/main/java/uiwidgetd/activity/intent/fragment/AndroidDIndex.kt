package uiwidgetd.activity.intent.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityAndroidDindexBinding

class AndroidDIndex : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidDindexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidDindexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityLifeCycle.setOnClickListener {
            startActivity(Intent(this, ActivityLifeCycleDemo::class.java))
        }
        binding.fragmentLifeCycle.setOnClickListener {
            startActivity(Intent(this, FragmentLifeCycleDemo::class.java))
        }
        binding.intent.setOnClickListener {
            startActivity(Intent(this, IntentIndex::class.java))
        }
        binding.fragment.setOnClickListener {
            startActivity(Intent(this, Fragments::class.java))
        }
        binding.practicalOne.setOnClickListener {
            startActivity(Intent(this, ExerciseOne::class.java))
        }
        binding.practicalTwo.setOnClickListener {
            startActivity(Intent(this, ExerciseTwo::class.java))
        }
        binding.practicalThree.setOnClickListener {
            startActivity(Intent(this, ExerciseThree::class.java))
        }
        binding.practicalFour.setOnClickListener {
            startActivity(Intent(this, ExerciseFour::class.java))
        }
        binding.pendingIntent.setOnClickListener {
            startActivity(Intent(this, PendingIntent::class.java))
        }
        binding.intentFilter.setOnClickListener {
            startActivity(Intent(this, IntentFilter::class.java))
        }
    }

}