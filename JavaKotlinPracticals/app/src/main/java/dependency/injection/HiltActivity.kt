package dependency.injection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.javakotlinpracticals.databinding.ActivityHiltBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    /** Variables */
    private lateinit var binding: ActivityHiltBinding
    private val viewModel: PersonViewModel by viewModels()

    /** Overridden Method */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHiltBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("Hilt", "onCreate $this")
        Log.d("Hilt", "$viewModel")
        setUpData()
    }

    /** Class Method */
    private fun setUpData() {
        viewModel.personData.observe(this) {
            binding.rvPersonDetails.adapter = PersonDetailsAdapter(this, it)
        }
    }

}