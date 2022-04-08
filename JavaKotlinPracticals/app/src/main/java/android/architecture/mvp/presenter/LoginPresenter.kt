package android.architecture.mvp.presenter

import android.architecture.mvp.model.User
import android.architecture.mvp.model.ILoginView
import android.architecture.mvp.model.Validation

class LoginPresenter(private val loginView: ILoginView): ILoginPresenter {

    override fun login(email: String?, password: String?) {
        val user = User(email, password)

        when(user.isValid()) {
            Validation.EmailEmpty.toString() -> loginView.onLoginFail(Validation.EmailEmpty.message)
            Validation.EmailValidation.toString() -> loginView.onLoginFail(Validation.EmailValidation.message)
            Validation.PasswordEmpty.toString() -> loginView.onLoginFail(Validation.PasswordEmpty.message)
            Validation.PasswordValidation.toString() -> loginView.onLoginFail(Validation.PasswordValidation.message)
            Validation.Success.toString() -> loginView.onLoginSuccess(Validation.Success.message)
        }
    }

}