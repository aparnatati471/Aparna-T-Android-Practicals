package uiwidgetd.activity.intent.fragment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.javakotlinpracticals.databinding.ActivityIntentFilterBinding

class IntentFilter : AppCompatActivity() {

    private lateinit var binding: ActivityIntentFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentFilterBinding.inflate(layoutInflater)
        binding.view.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW))
        }
        setContentView(binding.root)
    }

    fun sendEmail(view: View) {
        val email = binding.edtEmailid.text
        val subject = binding.edtSubject.text
        val message = binding.edtMessage.text
        val intent = Intent(Intent.ACTION_SEND)

        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, message)
        intent.type = "message/*"

        startActivity(Intent.createChooser(intent, "Choose an email client"))
    }

}