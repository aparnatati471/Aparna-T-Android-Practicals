package uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.javakotlinpracticals.databinding.ActivityMdcformBinding
import android.R
import android.content.Intent
import android.view.Gravity
import com.example.javakotlinpracticals.databinding.ActivityCustomToastBinding

class MDCForm : AppCompatActivity() {

    private lateinit var binding: ActivityMdcformBinding
    private lateinit var binding2: ActivityCustomToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMdcformBinding.inflate(layoutInflater)
        binding2 = ActivityCustomToastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = binding.username.text.toString()
        val email = binding.email.text.toString()
        val password = binding.password.text.toString()

        binding.signup.setOnClickListener {
            checkForValidation(username, email, password)
        }
        binding.arrowMdc.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun checkForValidation(username: String, email: String, password: String) {
        if(username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this,"This Fields Can Not be Empty", Toast.LENGTH_LONG).show()
        } else {
            displayDetails(username, email, password)
        }
    }

    private fun displayDetails(username: String, email: String, password: String) {
        val result = StringBuilder()
        result.append("Username: $username")
        result.append("\nEmail: $email")
        result.append("\nPassword: $password")

        val id = binding.radioGroupGender.checkedRadioButtonId
        val selectedGender: RadioButton = findViewById(id)
        result.append("\nGender: ${selectedGender.text}")

        val checkBoxResult = StringBuilder()
        if(binding.chkjava.isChecked) {
            checkBoxResult.append(binding.chkjava.text.toString())
        }
        if(binding.chkkotlin.isChecked) {
            checkBoxResult.append(binding.chkkotlin.text.toString())
        }
        if(binding.chkswift.isChecked) {
            checkBoxResult.append(binding.chkswift.text.toString())
        }

        result.append("\nLangugaes: $checkBoxResult")

        val layout = layoutInflater.inflate(R.layout.list_content, binding2.customToast)
        val context = applicationContext
        val duration = Toast.LENGTH_LONG
        val text = binding2.tvMessage
        text.text = result.toString()

        val toast = Toast(context)
        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0)
        toast.duration = duration
        toast.view = layout
        toast.show()
    }

}