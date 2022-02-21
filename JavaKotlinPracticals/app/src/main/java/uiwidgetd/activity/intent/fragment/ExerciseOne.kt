package uiwidgetd.activity.intent.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityExerciseOneBinding

class ExerciseOne : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(GalleryFragment())
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bottom_nav_gallery -> replaceFragment(GalleryFragment())
                R.id.bottom_nav_send_msg -> replaceFragment(AddMessageFragment())
                R.id.bottom_nav_view_msg -> replaceFragment(ViewMessageFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_cotainer, fragment)
        transaction.commit()
    }

}