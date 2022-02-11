package uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityTableLayoutBinding

class TableLayout : AppCompatActivity() {

    private lateinit var binding: ActivityTableLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTableLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}