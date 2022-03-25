package webservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.javakotlinpracticals.databinding.ActivityWebServicesIndexBinding

class WebServicesIndex : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityWebServicesIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebServicesIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickOne = this
       // navigation()
    }

    private fun navigation() {
        var intent: Intent

        // Click event for navigate to Login Activity
        binding.btExercise.setOnClickListener {
            intent = Intent(this, WebLogin::class.java)
            startActivity(intent)
        }

        // Click event for navigate to JSON Activity
        binding.btJson.setOnClickListener {
            intent = Intent(this, JsonParsing::class.java)
            startActivity(intent)
        }

        // Click event for navigate to GSON Activity
        binding.btGson.setOnClickListener {
            intent = Intent(this, GsonParsing::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btExercise.id ->
                startActivity(Intent(this, WebLogin::class.java))
            binding.btJson.id ->
                startActivity(Intent(this, JsonParsing::class.java))
            binding.btGson.id ->
                startActivity(Intent(this, GsonParsing::class.java))
        }
    }

}