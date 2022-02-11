package uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import com.example.javakotlinpracticals.databinding.ActivityConstraintLayoutBinding
import java.lang.StringBuilder

class ConstraintLayout : AppCompatActivity() {

    private lateinit var binding: ActivityConstraintLayoutBinding
    val result = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.email.text.toString()
        val password = binding.password.text.toString()
        val confirm_pass = binding.confirmpassword.text.toString()
        val phone = binding.phone.text.toString()

        setUpSpinner()

        binding.btcreate.setOnClickListener {
            checkValidation(email, password, phone)
        }
    }

    private fun checkValidation(email_id: String, password_org: String, phone_no: String) {
        result.append("Email : $email_id\n")
        result.append("Password: $password_org\n")
        result.append("Phone: $phone_no\n")

        val id  = binding.radioGroupGender.checkedRadioButtonId
        val selectedGender: RadioButton = findViewById(id)
        val gender: String = selectedGender.text.toString()
        result.append("Gender: $gender\n")
        Toast.makeText(this, result, Toast.LENGTH_LONG).show()
    }

    private fun setUpSpinner() {
        val countries = arrayOf("India", "USA", "UK", "Canada", "Japan")
        var spinner = binding.spinner
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        spinner.adapter = arrayAdapter
        var item: String

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                item = countries[p2]
                result.append("Country: $item\n")
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

}