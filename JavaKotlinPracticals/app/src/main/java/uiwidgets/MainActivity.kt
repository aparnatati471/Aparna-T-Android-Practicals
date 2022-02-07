package uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.simpleForm.setOnClickListener {
            startActivity(Intent(this, Registeration::class.java))
            finish()
        }
        binding.materialForm.setOnClickListener {
            startActivity(Intent(this, MDCForm::class.java))
            finish()
        }
        binding.rippleEffect.setOnClickListener {
            startActivity(Intent(this, RippleEffect::class.java))
            finish()
        }
    }

}