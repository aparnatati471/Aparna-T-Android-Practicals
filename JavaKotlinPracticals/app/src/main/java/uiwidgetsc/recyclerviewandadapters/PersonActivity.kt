package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityPersonBinding

class PersonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Glide.with(this).load(intent.getIntExtra("Image", R.drawable.a)).into(binding.secondimageview)
        binding.secondname.text = intent.getStringExtra("Name")
        binding.secondmsg.text = intent.getStringExtra("Message")
    }

}