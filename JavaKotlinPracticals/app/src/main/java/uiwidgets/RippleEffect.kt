package uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityRippleEffectBinding

class RippleEffect : AppCompatActivity() {

    private lateinit var binding: ActivityRippleEffectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRippleEffectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.arrowRipple.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

}