package permission.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.javakotlinpracticals.databinding.ActivityPermissionModelIndexBinding

class PermissionModelIndex : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPermissionModelIndexBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionModelIndexBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickOne = this
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btnPermissionDemo1.id ->
                startActivity(Intent(this, DemoOne::class.java))
            binding.btnPermissionDemo2.id ->
                startActivity(Intent(this, DemoTwo::class.java))
        }
    }

}