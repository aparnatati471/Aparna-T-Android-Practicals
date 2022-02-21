package uiwidgetd.activity.intent.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityIntentIndexBinding

class IntentIndex : AppCompatActivity() {

    private lateinit var binding: ActivityIntentIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btImplicitIntent.setOnClickListener {
            startActivity(Intent(this, ImplicitIntent::class.java))
        }
        binding.btRetreive.setOnClickListener {
            startActivity(Intent(this, StartActivityForResultOne::class.java))
        }
    }

}