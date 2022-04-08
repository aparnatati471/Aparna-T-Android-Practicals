package android.architecture.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityViewModelScopeExampleBinding

class ViewModelScopeExample : AppCompatActivity() {

    private lateinit var binding: ActivityViewModelScopeExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelScopeExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}