package uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.javakotlinpracticals.databinding.ActivityGridViewBinding

class GridView : AppCompatActivity() {

    private lateinit var binding: ActivityGridViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cardviewone.setOnClickListener {
            showToast("Home Clicked")
        }
        binding.cardviewtwo.setOnClickListener {
            showToast("Chat Clicked")
        }
        binding.cardviewthree.setOnClickListener {
            showToast("Profile Clicked")
        }
        binding.cardviewfour.setOnClickListener {
            showToast("Widget Clicked")
        }
        binding.cardviewfive.setOnClickListener {
            showToast("Settings Clicked")
        }
        binding.cardviewsix.setOnClickListener {
            showToast("Logout Clicked")
        }
    }

    private fun showToast(toastmsg: String) {
        Toast.makeText(this, toastmsg, Toast.LENGTH_SHORT).show()
    }

}