package design.support.library

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityCoordinatorLayoutTwoBinding
import com.google.android.material.snackbar.Snackbar

class CoordinatorLayoutTwo : AppCompatActivity() {

    private lateinit var binding: ActivityCoordinatorLayoutTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoordinatorLayoutTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.fab.setOnClickListener {
            Snackbar.make(it, R.string.toast_msg, Snackbar.LENGTH_LONG)
                .setAction(R.string.action) {
                    Toast.makeText(this, R.string.action_clicked, Toast.LENGTH_LONG).show()
                }
                .setActionTextColor(Color.WHITE)
                .setBackgroundTint(Color.DKGRAY)
                .show()
        }
    }
}