package uiwidgetd.activity.intent.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityFragmentLifeCycleDemoBinding

class FragmentLifeCycleDemo : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentLifeCycleDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentLifeCycleDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        printLog("OnCreate")
        binding.btLoadFragment.setOnClickListener {
            val fragment: Fragment = FragmentOneDemo()
            val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.f_framelayout, fragment).addToBackStack("My Fragment").commit()
        }
    }

    override fun onStart() {
        super.onStart()
        printLog("OnStart")
    }

    override fun onResume() {
        super.onResume()
        printLog("OnResume")
    }

    override fun onRestart() {
        super.onRestart()
        printLog("OnRestart")
    }

    override fun onPause() {
        super.onPause()
        printLog("OnPause")
    }

    override fun onStop() {
        super.onStop()
        printLog("OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        printLog("OnDestroy")
    }

    private fun printLog(s: String) {
        Log.d("ActivityLifeCycle:", s)
    }

}