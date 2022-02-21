package uiwidgetd.activity.intent.fragment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmReceiver: BroadcastReceiver() {

    override fun onReceive(p0: Context, p1: Intent) {
        val res = p1.getIntExtra("time", 0)
        Toast.makeText(p0, "Alarm Rignging after $res Seconds", Toast.LENGTH_LONG).show()
    }

}