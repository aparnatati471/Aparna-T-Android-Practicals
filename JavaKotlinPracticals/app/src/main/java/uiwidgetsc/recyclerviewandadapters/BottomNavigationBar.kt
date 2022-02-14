package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityBottomNavigationBarBinding
import uiwidgetsc.recyclerviewandadapters.fragments.HomeFragment
import uiwidgetsc.recyclerviewandadapters.fragments.ProfileFragment
import uiwidgetsc.recyclerviewandadapters.fragments.SearchFragment

class BottomNavigationBar : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(HomeFragment())
        binding.bottomnavigationbar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

}