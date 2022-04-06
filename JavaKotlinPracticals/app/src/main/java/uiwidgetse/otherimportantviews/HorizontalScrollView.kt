
package uiwidgetse.otherimportantviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.javakotlinpracticals.databinding.ActivityHorizontalScrollViewBinding

class HorizontalScrollView : AppCompatActivity() {

    private lateinit var binding: ActivityHorizontalScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalScrollViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}