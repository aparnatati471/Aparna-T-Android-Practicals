package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityPersonBinding

class PersonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.secondimageview.setImageResource(intent.getIntExtra("Image", R.drawable.a))
        binding.secondname.text = intent.getStringExtra("Name")
        binding.secondmsg.text = intent.getStringExtra("Message")
    }

}