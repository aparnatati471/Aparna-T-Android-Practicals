package uiwidgets

import android.architecture.ArchitectureIndex
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.javakotlinpracticals.databinding.ActivityExerciseBinding
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dependency.injection.HiltActivity
import design.support.library.AndroidDesignSupportIndex
import permission.model.PermissionModelIndex
import uiwidgetd.activity.intent.fragment.AndroidDIndex
import uiwidgetsc.recyclerviewandadapters.Index


class ExerciseActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application, "136a996a-5731-4079-a3f6-e31466991f1e",
            Analytics::class.java, Crashes::class.java
        )
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        binding.click = this
        setContentView(binding.root)
    }

    override fun onClick(p0: View) {
        when(p0.id) {
            binding.uiWidgetsA.id -> navigateToNext(MainActivity::class.java)
            binding.uiWidgetsB.id -> navigateToNext(LayoutsMain::class.java)
            binding.uiWidgetsC.id -> navigateToNext(Index::class.java)
            binding.uiWidgetsD.id -> navigateToNext(AndroidDIndex::class.java)
            binding.btnArchitecture.id -> navigateToNext(ArchitectureIndex::class.java)
            binding.btnPermissionModel.id -> navigateToNext(PermissionModelIndex::class.java)
            binding.btnDesignSupport.id -> navigateToNext(AndroidDesignSupportIndex::class.java)
            binding.btnDependencyInjection.id -> navigateToNext(HiltActivity::class.java)
        }
    }

    private fun navigateToNext(className: Class<*>) {
        startActivity(Intent(this, className))
    }
}