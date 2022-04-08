package android.architecture.mvp.model

interface ILoginView {

    fun onLoginSuccess(message: String?)
    fun onLoginFail(message: String?)

}