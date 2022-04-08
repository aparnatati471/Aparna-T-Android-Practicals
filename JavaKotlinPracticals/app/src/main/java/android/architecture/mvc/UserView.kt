package android.architecture.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.javakotlinpracticals.databinding.ActivityUserViewBinding

class UserView : AppCompatActivity() {

    private lateinit var binding: ActivityUserViewBinding
    private var model: User = User()
    private lateinit var controller: UserController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dismissKeyboard()
        login()
    }

    private fun dismissKeyboard() {
        binding.baselayout.setOnClickListener {
            if (currentFocus != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            }
        }
    }

    private fun login() {
        controller = UserController(model, this)
        binding.btnLogin.setOnClickListener {
            controller.setPassword(binding.password.text.toString())
            controller.setEmail(binding.edtEmail.text.toString())
            controller.validations()
        }
    }

    fun printDetails(email: String?, password: String?) {
        Toast.makeText(applicationContext, "Logged in suceessfull!! $email", Toast.LENGTH_LONG).show()
    }

    fun validationToast(message: String?) {
        Toast.makeText(applicationContext, message.toString(), Toast.LENGTH_LONG).show()
    }

}