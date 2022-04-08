package uiwidgets

import android.architecture.ArchitectureIndex
import android.architecture.mvc.UserView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.javakotlinpracticals.databinding.ActivityExerciseBinding
import design.support.library.AndroidDesignSupportIndex
import permission.model.PermissionModelIndex
import uiwidgetd.activity.intent.fragment.AndroidDIndex
import uiwidgetsc.recyclerviewandadapters.Index

class ExerciseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.uiWidgetsA.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.uiWidgetsB.setOnClickListener {
            startActivity(Intent(this, LayoutsMain::class.java))
        }
        binding.uiWidgetsC.setOnClickListener {
            startActivity(Intent(this, Index::class.java))
        }
        binding.uiWidgetsD.setOnClickListener {
            startActivity(Intent(this, AndroidDIndex::class.java))
        }
        binding.btnArchitecture.setOnClickListener {
            startActivity(Intent(this, ArchitectureIndex::class.java))
        }
        binding.btnPermissionModel.setOnClickListener {
            startActivity(Intent(this, PermissionModelIndex::class.java))
        }
        binding.btnDesignSupport.setOnClickListener {
            startActivity(Intent(this, AndroidDesignSupportIndex::class.java))
        }
    }

}