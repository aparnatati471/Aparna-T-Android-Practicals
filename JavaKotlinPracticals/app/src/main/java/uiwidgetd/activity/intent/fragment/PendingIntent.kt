package uiwidgetd.activity.intent.fragment

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.PendingIntent.getBroadcast
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.javakotlinpracticals.databinding.ActivityPendingIntentBinding

class PendingIntent : AppCompatActivity() {

    private lateinit var binding: ActivityPendingIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPendingIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun alarm(view: View) {
        val intent = Intent(this, ExerciseFour::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + (3 * 1000), pendingIntent
        )
    }

}