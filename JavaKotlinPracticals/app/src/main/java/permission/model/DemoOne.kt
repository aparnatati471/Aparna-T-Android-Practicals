package permission.model

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.javakotlinpracticals.databinding.ActivityDemoOneBinding

class DemoOne : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDemoOneBinding
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private val CAMERA_PERMISSION_CODE = 112
    private val EXTERNAL_STORAGE_CODE = 113
    private var isSendSMSPermissionGranted: Boolean = false
    private var isCallPermissionGranted: Boolean = false
    private var isCameraPermissionGranted: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickOne = this
        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permission ->
            isSendSMSPermissionGranted = permission[android.Manifest.permission.SEND_SMS] ?: isSendSMSPermissionGranted
            isCameraPermissionGranted = permission[android.Manifest.permission.CAMERA] ?: isCameraPermissionGranted
            isCallPermissionGranted = permission[android.Manifest.permission.CALL_PHONE] ?: isCallPermissionGranted
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            binding.btnCameraPermission.id ->
                checkPermission(android.Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
            binding.btnExternalPermission.id ->
                checkPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE, EXTERNAL_STORAGE_CODE)
            binding.btnMultiplePermission.id ->
                requestPermission()
        }
    }

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(applicationContext, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        } else {
            Toast.makeText(this, "Permission Already Granted", Toast.LENGTH_LONG).show()
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
            EXTERNAL_STORAGE_CODE -> check("External Storage")
        }
    }

    private fun check(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(applicationContext, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission() {
        isSendSMSPermissionGranted = check(android.Manifest.permission.SEND_SMS)
        isCallPermissionGranted = check(android.Manifest.permission.CALL_PHONE)
        isCameraPermissionGranted = check(android.Manifest.permission.CAMERA)

        val permissionsRequest: MutableList<String> = ArrayList()

        if (!isSendSMSPermissionGranted) {
            permissionsRequest.add(android.Manifest.permission.SEND_SMS)
        }
        if (!isCallPermissionGranted) {
            permissionsRequest.add(android.Manifest.permission.CALL_PHONE)
        }
        if (!isCameraPermissionGranted) {
            permissionsRequest.add(android.Manifest.permission.CAMERA)
        }
        if (permissionsRequest.isNotEmpty()) {
            permissionLauncher.launch(permissionsRequest.toTypedArray())
        }
    }

}