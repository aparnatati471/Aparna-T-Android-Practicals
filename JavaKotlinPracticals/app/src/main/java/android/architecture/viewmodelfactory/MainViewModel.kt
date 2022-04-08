package android.architecture.viewmodelfactory

import androidx.lifecycle.ViewModel

class MainViewModel(initialValue: Int): ViewModel() {

    var count: Int = initialValue

    fun increment() {
        count++
    }

}