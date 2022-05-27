package dependency.injection

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltApplication: Application() {

    init {
        Log.d("Hilt", this.toString())
    }

}
