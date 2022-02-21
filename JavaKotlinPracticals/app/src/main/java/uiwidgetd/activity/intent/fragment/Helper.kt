package uiwidgetd.activity.intent.fragment

import android.app.Activity
import androidx.activity.result.ActivityResult

const val RESULT_TEXT = "RESULT_TEXT"

fun ActivityResult.isResultOk(): Boolean = resultCode == Activity.RESULT_OK