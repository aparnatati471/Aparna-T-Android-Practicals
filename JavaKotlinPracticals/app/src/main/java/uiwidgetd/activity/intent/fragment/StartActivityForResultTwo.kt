package uiwidgetd.activity.intent.fragment

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityStartForResultTwoBinding

class StartActivityForResultTwo : AppCompatActivity() {

    private lateinit var binding: ActivityStartForResultTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartForResultTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btSend.setOnClickListener {
            setActivityResult()
            finish()
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        super.onBackPressed()
    }

    private fun setActivityResult() {
        val intent = Intent()
        intent.putExtra(RESULT_TEXT, getString(R.string.the_result_string, binding.editText1.text))
        setResult(Activity.RESULT_OK, intent)
    }

}