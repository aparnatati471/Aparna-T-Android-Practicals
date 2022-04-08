package design.support.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.SearchView
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityTabLayoutWithCoordinatorLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutWithCoordinatorLayout : AppCompatActivity() {

    private lateinit var binding: ActivityTabLayoutWithCoordinatorLayoutBinding
    private lateinit var adapter: TabLayoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutWithCoordinatorLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewPager()
    }

    private fun setUpViewPager() {
        val viewpager = binding.vpWhatsapp
        val tablayout = binding.tlWhatsapp

        adapter = TabLayoutAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tablayout, viewpager) { tab, pos ->
            tab.text = TabLayoutAdapter.title[pos]
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_search_menu, menu)
        val search = menu?.findItem(R.id.searchchats)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = "Search"

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}