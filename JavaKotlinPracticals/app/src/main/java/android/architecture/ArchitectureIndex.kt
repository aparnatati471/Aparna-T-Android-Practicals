package android.architecture

import android.architecture.bindingandinverseadapters.BindingAndReverseBindingAdapters
import android.architecture.coroutines.CoroutineAPICalling
import android.architecture.mvc.UserView
import android.architecture.mvp.presenter.MVPLogin
import android.architecture.mvvm.view.MvvmLogin
import android.architecture.viewmodelfactory.ViewModelFactory
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityArchitectureIndexBinding

class ArchitectureIndex : AppCompatActivity() {

    private lateinit var binding: ActivityArchitectureIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArchitectureIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMvc.setOnClickListener {
            startActivity(Intent(this, UserView::class.java))
        }

        binding.btnMvp.setOnClickListener {
            startActivity(Intent(this, MVPLogin::class.java))
        }

        binding.btnMvvm.setOnClickListener {
            startActivity(Intent(this, MvvmLogin::class.java))
        }

        binding.btnInversebinding.setOnClickListener {
            startActivity(Intent(this, ViewModelFactory::class.java))
        }

        binding.btnCoroutine.setOnClickListener {
            startActivity(Intent(this, CoroutineAPICalling::class.java))
        }
    }

}