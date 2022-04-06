package uiwidgetse.otherimportantviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.javakotlinpracticals.BR
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityAndroidEindexBinding
import uiwidgetsc.recyclerviewandadapters.RecyclerViewCheckbox

class AndroidEIndex : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAndroidEindexBinding
    private lateinit var buttonClickBinding: ActivityAndroidEindexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidEindexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickOne = this
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btnListviewSearch.id ->
                startActivity(Intent(applicationContext, ListViewSearch::class.java))
            binding.btnRecyclerviewSearch.id ->
                startActivity(Intent(applicationContext, RecyclerViewCheckbox::class.java))
            binding.btnWebview.id ->
                startActivity(Intent(applicationContext, WebView::class.java))
            binding.btnHorizontalScrollView.id ->
                startActivity(Intent(applicationContext, HorizontalScrollView::class.java))
            binding.btnHorizontalScrollViewSearch.id ->
                startActivity(Intent(applicationContext, HorizontalScrollViewSearch::class.java))
            binding.btnNestedScrollView.id ->
                startActivity(Intent(applicationContext, NestedScrollView::class.java))
        }
    }

}