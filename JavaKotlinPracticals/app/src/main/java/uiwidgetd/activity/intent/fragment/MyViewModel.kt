package uiwidgetd.activity.intent.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    var count = 1
    val edittextMsg: MutableLiveData<String> = MutableLiveData()

    fun updateEditTextData(editedData: String) {
        edittextMsg.postValue(editedData)
    }

}