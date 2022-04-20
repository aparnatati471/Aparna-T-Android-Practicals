package webservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.javakotlinpracticals.databinding.ActivityWebLoginBinding
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class WebLogin : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityWebLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickOne = this
    }

    private fun login() {
        Thread(kotlinx.coroutines.Runnable {
            try {
                val result = sendPostRequest(
                    binding.email.text.toString(),
                    binding.password.text.toString()
                )
                runOnUiThread {
                    if (result) {
                        val intent = Intent(this, RetrofitRecyclerView::class.java)
                        startActivity(intent)
                        Toast.makeText(
                            applicationContext,
                            "Login Successfully!!",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    } else {
                        Toast.makeText(applicationContext, "Login Failed!!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }).start()
    }

    private fun sendPostRequest(username: String, password: String): Boolean {
        val data = JSONObject()
        data.put("email", username)
        data.put("password", password)

        var responseStatus: Boolean
        val url = URL("https://reqres.in/api/login")

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json")
            val wr = OutputStreamWriter(outputStream)
            wr.write(data.toString())
            wr.flush()
            Log.d("URL", "$url")
            Log.d("Data", "$data")
            Log.d("Response", "$responseCode")
            responseStatus = responseCode == HttpsURLConnection.HTTP_OK
        }
        return responseStatus
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.btlogin.id ->
                login()
        }
    }

}