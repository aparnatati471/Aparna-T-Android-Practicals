package uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityTabLayoutBinding

class TabLayout : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        val viewPager = binding.viewPager
        viewPager.adapter = fragmentAdapter

        val tabLayout = binding.tablayout
        tabLayout.setupWithViewPager(viewPager)
    }

}