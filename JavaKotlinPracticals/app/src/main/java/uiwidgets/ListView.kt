package uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.javakotlinpracticals.databinding.ActivityListViewBinding
import java.lang.StringBuilder

class ListView : AppCompatActivity() {

    private lateinit var binding: ActivityListViewBinding

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView = binding.listview
        val arroflang = arrayOf("Kotlin", "Swift", "Java", "PHP", "Flutter", "React Native", "Data Structure", "Artificial Intelligence")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, arroflang)
        listView.adapter = adapter

        binding.submit.setOnClickListener {
            var i = 0
            val selected = StringBuilder()

            while (i < listView.count) {
                if(listView.isItemChecked(i)) {
                    selected.append(listView.getItemAtPosition(i))
                }
                i += 1
            }

            Toast.makeText(this, selected.toString(), Toast.LENGTH_LONG).show()
        }
    }

}