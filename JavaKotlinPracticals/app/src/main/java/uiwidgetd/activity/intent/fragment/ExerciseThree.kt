package uiwidgetd.activity.intent.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityExerciseThreeBinding

class ExerciseThree : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpFragments()
    }

    private fun setUpFragments() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, InputFragment::class.java, null)
            .commit()
    }

}