package android.architecture.mvp.model

import android.text.TextUtils
import android.util.Patterns

enum class Validation(val message: String) {
    EmailEmpty("Please Enter Your Email"),
    PasswordEmpty("Please Enter Your Password"),
    EmailValidation("Please Enter Valid Email Address"),
    PasswordValidation("Please Enter Password greater than 6 Characters"),
    Success("Login Successfull"),
    Fail("Login Failed")
}

class User(private val email: String?, private val password: String?): IUser {

    override fun getEmail(): String? {
        return email
    }

    override fun getPassword(): String? {
        return password
    }

    override fun isValid(): String {
        return if (TextUtils.isEmpty(getEmail()))
            Validation.EmailEmpty.toString()
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            Validation.EmailValidation.toString()
        else if (TextUtils.isEmpty(getPassword()))
            Validation.PasswordEmpty.toString()
        else if (getPassword()?.length!! <= 6)
            Validation.PasswordValidation.toString()
        else
            Validation.Success.toString()
    }

}