package android.architecture.viewmodelfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.javakotlinpracticals.databinding.ActivityViewModelFactoryBinding

class ViewModelFactory : AppCompatActivity() {

    private lateinit var binding: ActivityViewModelFactoryBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewModelFactoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this, MainVMFactory(19))[MainViewModel::class.java]
        setCounterValue()
    }

    private fun setCounterValue() {
        binding.txtCounter.text = mainViewModel.count.toString()
    }

    fun click(view: View) {
        mainViewModel.increment()
        setCounterValue()
    }

}