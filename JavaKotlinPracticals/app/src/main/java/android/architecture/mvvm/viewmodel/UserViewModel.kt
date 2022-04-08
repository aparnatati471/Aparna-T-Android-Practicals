package android.architecture.mvvm.viewmodel

import android.architecture.mvvm.model.User
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {

    var toastMessage = MutableLiveData<String>()
    var imageURL = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    private val userMutableLiveData = MutableLiveData<User>()

    fun onClick() {
        val loginUser = User(email = email.value, password = password.value, "https://www.w3schools.com/w3images/avatar6.png")
        val res = loginUser.isValid()
        setToastMessage(res)
        imageLoad(loginUser.photo.toString())
        userMutableLiveData.value = loginUser
    }

    private fun setToastMessage(message: String) {
        this.toastMessage.value = message
    }

    private fun imageLoad(photo: String) {
        this.imageURL.value = photo
    }

}