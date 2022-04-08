package android.architecture.mvvm.model

import android.architecture.mvp.model.Validation
import android.text.TextUtils
import android.util.Patterns

data class User(var email: String? = "", var password: String? = "", val photo: String? = null) {

    fun isValid(): String {
        return if (TextUtils.isEmpty(email))
            Validation.EmailEmpty.message
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            Validation.EmailValidation.message
        else if (TextUtils.isEmpty(password))
            Validation.PasswordEmpty.message
        else if (password?.length!! <= 6)
            Validation.PasswordValidation.message
        else
            Validation.Success.message + "" + email
    }

}
