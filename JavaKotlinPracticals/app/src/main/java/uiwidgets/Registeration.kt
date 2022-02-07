package uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.javakotlinpracticals.databinding.ActivityRegisteration2Binding
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class Registeration : AppCompatActivity() {

    private lateinit var binding: ActivityRegisteration2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisteration2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonsignup.setOnClickListener {
            checkForAuthentication(it)
        }
        binding.arrowSimple.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun checkForAuthentication(view: View) {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if(email.equals("Aparna",false) && password.equals("1234")) {
            val snake = Snackbar.make(view, "Hi, $email Signup Successfully", Snackbar.LENGTH_LONG)
            snake.setAction("Show Details..", { displayDetails() })
            snake.show()
        } else {
            Toast.makeText(this, "Invalid Signup Attempt", Toast.LENGTH_LONG).show()
        }
    }

    private fun displayDetails() {
        Toast.makeText(this, "Signup Successfull! ${Calendar.getInstance().time}", Toast.LENGTH_LONG).show()
    }

}