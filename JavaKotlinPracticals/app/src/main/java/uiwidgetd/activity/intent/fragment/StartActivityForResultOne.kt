package uiwidgetd.activity.intent.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.javakotlinpracticals.databinding.ActivityStartForResultOneBinding

class StartActivityForResultOne : AppCompatActivity() {

    private lateinit var binding: ActivityStartForResultOneBinding

    private val secondActivityWithResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.isResultOk()) {
            if (result.data?.hasExtra(RESULT_TEXT) == true) {
                binding.txtMsg.text = result.data?.extras?.getString(RESULT_TEXT) ?: "No Result Provided"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartForResultOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btClickon.setOnClickListener {
            val intent = Intent(this, ImplicitIntent::class.java)
            secondActivityWithResult.launch(intent)
        }
    }

}