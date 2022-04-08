package permission.model

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.javakotlinpracticals.databinding.ActivityDemoTwoBinding
import java.io.File
import java.io.FileOutputStream

class DemoTwo : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDemoTwoBinding
    private val CAMERA_PERMISSION_CODE = 112
    private val GALLERY_STORAGE_CODE = 113
    private lateinit var bitmap: Bitmap

    private val cameraActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        bitmap = result.data?.extras?.get("data") as Bitmap
        binding.imgDisp.setImageBitmap(bitmap)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickOne = this
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btnCameraImg.id ->
                checkPermission(android.Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
            binding.btnGalleryImg.id ->
                checkPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE, GALLERY_STORAGE_CODE)
            binding.btnSaveImg.id ->
                saveImageToGallery(bitmap)
        }
    }

    private val getAction = registerForActivityResult(
        ActivityResultContracts.GetContent(), ActivityResultCallback { uri ->
            binding.imgDisp.setImageURI(uri)
        }
    )

    private fun saveImageToGallery(img: Bitmap) {
        val rootPath = Environment.getExternalStorageDirectory().toString()
        val directory = File("$rootPath/Pictures")
        if (!directory.exists()) {
            directory.mkdir()
        }
        val imageName = "${System.currentTimeMillis()}.jpg"
        val file = File(directory, imageName)
        try {
            val out = FileOutputStream(file)
            img.compress(Bitmap.CompressFormat.JPEG, 100, out)
            out.flush()
            out.close()
            Toast.makeText(applicationContext, "Image Saved Successfully!!", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Log.d("Error", e.message.toString())
        }
    }

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(applicationContext, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this, "Permission Already Granted", Toast.LENGTH_LONG).show()
            when(requestCode) {
                CAMERA_PERMISSION_CODE -> camera()
                GALLERY_STORAGE_CODE -> gallery()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        fun check(permissionName: String) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(applicationContext, "$permissionName Permission Granted", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "$permissionName Permission Denied", Toast.LENGTH_LONG).show()
            }
        }
        when(requestCode) {
            CAMERA_PERMISSION_CODE -> check("Camera")
            GALLERY_STORAGE_CODE -> check("Gallery")
        }
    }

    private fun camera() {
        try {
            val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraActivity.launch(camera)
        } catch (e: Exception) {
            print(e.toString())
        }
    }

    private fun gallery() {
        getAction.launch("image/*")
    }

}