package uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityFrameLayoutBinding

class FrameLayout : AppCompatActivity() {

    private lateinit var binding: ActivityFrameLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrameLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bt1.setOnClickListener { switchFragment(1) }
        binding.bt2.setOnClickListener { switchFragment(2) }
        switchFragment(1)
    }

    private fun switchFragment(intWhich: Int) {

        var fragment: Fragment? = null

        when(intWhich) {
            1 -> fragment = FrameOne()
            2 -> fragment = FrameTwo()
        }

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        if (fragment != null) {
            fragmentTransaction.replace(R.id.framelayout, fragment)
        }

        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}