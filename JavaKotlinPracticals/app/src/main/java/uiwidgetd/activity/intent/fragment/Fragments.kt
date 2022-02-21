package uiwidgetd.activity.intent.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityFragmentsBinding

class Fragments : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button1.setOnClickListener {
            replaceFragment(FragmentsOne())
        }
        binding.button2.setOnClickListener {
            replaceFragment(FragmentsTwo())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        val id = supportFragmentManager.findFragmentById(R.id.fragment_cotainer)
        Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()
        transaction.replace(R.id.fragment_cotainer, fragment)
        transaction.addToBackStack("Fragment")
        transaction.commit()
        val transactionTwo = supportFragmentManager.beginTransaction()
        transactionTwo.add(R.id.fragment_cotainer, FragmentsOne())
        transactionTwo.addToBackStack("Fragment")
        transactionTwo.commit()
    }

}