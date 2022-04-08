package android.architecture.mvp.presenter

import android.architecture.mvp.model.ILoginView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.javakotlinpracticals.databinding.ActivityMvcloginBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MVPLogin : AppCompatActivity(), ILoginView {

    private lateinit var binding: ActivityMvcloginBinding
    var email: TextInputEditText? = null
    var password: TextInputEditText? = null
    var login: MaterialButton? = null
    var loginPresenter: ILoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcloginBinding.inflate(layoutInflater)
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
        email = binding.edtEmail
        password = binding.password
        login = binding.btnLogin
        loginPresenter = LoginPresenter(this)
        login?.setOnClickListener {
            loginPresenter?.login(email?.text.toString(), password?.text.toString())
        }
    }

    override fun onLoginSuccess(message: String?) {
        Toast.makeText(applicationContext, message + email?.text.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onLoginFail(message: String?) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

}