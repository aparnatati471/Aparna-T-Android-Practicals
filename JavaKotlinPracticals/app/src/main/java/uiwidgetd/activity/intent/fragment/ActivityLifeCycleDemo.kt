package uiwidgetd.activity.intent.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.javakotlinpracticals.databinding.ActivityLifeCycleBinding

class ActivityLifeCycleDemo : AppCompatActivity() {

    private lateinit var binding: ActivityLifeCycleBinding
    private val sb = StringBuilder()
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        viewModelFun()
        msg("onCreate() Called")
        setContentView(binding.root)
    }

    private fun viewModelFun() {
        //Without View Model
        binding.txtCount.text = count.toString()
        binding.txtCount.setOnClickListener {
            count += 1
            binding.txtCount.text = count.toString()
        }
        //With View Model
        val myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        binding.txtCount.text = myViewModel.count.toString()
        binding.txtCount.setOnClickListener {
            myViewModel.count += 1
            binding.txtCount.text = myViewModel.count.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        msg("onStart() Called")
    }

    override fun onResume() {
        super.onResume()
        msg("onResume() Called")
    }

    override fun onPause() {
        super.onPause()
        msg("onPause() Called")
    }

    override fun onRestart() {
        super.onRestart()
        msg("onRestart() Called")
    }

    override fun onStop() {
        super.onStop()
        msg("onStop() Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        msg("onDestroy() Called")
    }

    private fun msg(message: String) {
        binding.txtLifecycle.text = sb.append(message + "\n")
    }

}