package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPager : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewpager = binding.viewpager
        val tablayout = binding.tablayout
        val title = arrayOf("Recent", "My Favourites")

        viewpager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tablayout, viewpager) { tab, pos ->
            tab.text = title[pos]
        }.attach()
    }

}