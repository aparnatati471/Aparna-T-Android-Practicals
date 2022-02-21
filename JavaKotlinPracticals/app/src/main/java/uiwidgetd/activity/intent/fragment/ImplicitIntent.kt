package uiwidgetd.activity.intent.fragment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityImplicitIntentBinding

class ImplicitIntent : AppCompatActivity() {

    private lateinit var binding: ActivityImplicitIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImplicitIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        implicitIntent()
    }

    private fun implicitIntent() {
        val implicitspinner = binding.spinner
        val adapter = ArrayAdapter.createFromResource(this, R.array.intents, android.R.layout.simple_spinner_item)
        implicitspinner.adapter = adapter
        binding.btClick.setOnClickListener {
            intent = when (implicitspinner.selectedItemPosition) {
                0 -> Intent(Intent.ACTION_VIEW, Uri.parse("https://www.javatpoint.com/"))
                1 -> Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+91)7573906914"))
                2 -> Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.0387,72.6308"))
                3 -> Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=Shyam Sikhar Bapunagar"))
                4 -> Intent("android.media.action.IMAGE_CAPTURE")
                5 -> Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"))
                else -> Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"))
            }
            if (intent != null) {
                startActivity(intent)
            }
        }
    }

}