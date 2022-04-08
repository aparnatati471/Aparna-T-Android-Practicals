package design.support.library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.javakotlinpracticals.databinding.ActivityAndroidDesignSupportIndexBinding

class AndroidDesignSupportIndex : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAndroidDesignSupportIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidDesignSupportIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickOne = this
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btnNavigationView.id ->
                startActivity(Intent(this, NavigationView::class.java))
            binding.btnCoordinatorLayout.id ->
                startActivity(Intent(this, CoordinatorLayoutTwo::class.java))
            binding.btnTabbarCoordinator.id ->
                startActivity(Intent(this, TabLayoutWithCoordinatorLayout::class.java))
        }
    }

}