package android.architecture.mvc

import android.architecture.mvp.model.Validation
import android.text.TextUtils
import android.util.Patterns

class UserController(private val model: User, private val view: UserView) {

    private fun getEmail(): String? {
        return model.email
    }

    private fun getPassword(): String? {
        return model.password
    }

    fun setEmail(email: String) {
        model.email = email
    }

    fun setPassword(password: String) {
        model.password = password
    }

    fun validations(): Boolean {
        if (TextUtils.isEmpty(model.email)) {
            view.validationToast(Validation.EmailEmpty.message)
        } else if (TextUtils.isEmpty(model.password)) {
            view.validationToast(Validation.PasswordEmpty.message)
        } else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            view.validationToast(Validation.EmailValidation.message)
        } else if (getPassword()?.length!! <= 6) {
            view.validationToast(Validation.PasswordValidation.message)
        } else {
            view.printDetails(getEmail(), getPassword())
        }
        return false
    }

}