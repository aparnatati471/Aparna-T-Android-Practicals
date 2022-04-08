package android.architecture.mvp.model

interface IUser {

    fun getEmail(): String? = null
    fun getPassword(): String? = null
    fun isValid(): String

}