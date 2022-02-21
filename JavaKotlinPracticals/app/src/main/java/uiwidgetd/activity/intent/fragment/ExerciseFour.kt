package uiwidgetd.activity.intent.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityExerciseFourBinding

class ExerciseFour : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseFourBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseFourBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}