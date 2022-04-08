package design.support.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityNavigationViewBinding

class NavigationView : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationViewBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout = binding.drawerLayout
        val navView = binding.navigationView

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.nav_home -> toastMessage(R.string.home)
                R.id.nav_search -> toastMessage(R.string.search)
                R.id.nav_profile -> toastMessage(R.string.profile)
                R.id.nav_lock -> toastMessage(R.string.forgot_password)
                R.id.nav_settings -> toastMessage(R.string.settings)
                R.id.nav_chat -> toastMessage(R.string.chat)
                R.id.nav_settings1 -> toastMessage(R.string.settings)
                R.id.nav_chat1 -> toastMessage(R.string.chat)
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toastMessage(message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}