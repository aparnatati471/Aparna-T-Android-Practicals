package uiwidgetsc.recyclerviewandadapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityRecyclerViewCheckboxBinding

class RecyclerViewCheckbox : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewCheckboxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewCheckboxBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPersonList()
    }

    private fun getPersonList(){
        val recyclerview = binding.recyclerView
        recyclerview.adapter = RecyclerViewCheckboxAdapter(Data.getPersonData())
    }

}

