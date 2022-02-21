package uiwidgetd.activity.intent.fragment

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.javakotlinpracticals.R
import android.view.animation.AnimationUtils
import com.example.javakotlinpracticals.databinding.FragmentGalleryBinding
import android.net.Uri
import android.graphics.Bitmap
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.Navigation

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding
    private var isOpen = false
    private val secondActivityWithResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val imageUri: Uri? = result.data?.data
        binding.dispImage.setImageURI(imageUri)
    }
    private val cameraActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        val bitmap: Bitmap = result.data?.extras?.get("data") as Bitmap
        binding.dispImage.setImageBitmap(bitmap)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGalleryBinding.inflate(layoutInflater)
        binding.dispImage.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_galleryFragment_to_addMessageFragment)
        }
        setUp()
        return binding.root
    }

    private fun setUp() {
        val floatingCamera = binding.btnFloatingCamera
        val floatingGallery = binding.btnFloatingGallery
        val floatingAction = binding.btnFloatingAction

        val fabOpen = AnimationUtils.loadAnimation(this.context, R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this.context, R.anim.fab_close)
        val fabClockWise = AnimationUtils.loadAnimation(this.context, R.anim.rotate_clockwise)
        val fabAntiClockWise = AnimationUtils.loadAnimation(this.context,R.anim.rotate_anticlockwise)

        floatingAction.setOnClickListener {
            isOpen = if (isOpen) {
                floatingGallery.startAnimation(fabClose)
                floatingCamera.startAnimation(fabClose)
                floatingAction.startAnimation(fabClockWise)
                false
            } else {
                floatingCamera.startAnimation(fabOpen)
                floatingGallery.startAnimation(fabOpen)
                floatingAction.startAnimation(fabAntiClockWise)
                floatingGallery.isClickable
                floatingCamera.isClickable
                true
            }

            floatingGallery.setOnClickListener {
                val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                secondActivityWithResult.launch(gallery)
            }

            floatingCamera.setOnClickListener {
                val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if(camera != null) {
                    cameraActivity.launch(camera)
                }
            }
        }
    }

}