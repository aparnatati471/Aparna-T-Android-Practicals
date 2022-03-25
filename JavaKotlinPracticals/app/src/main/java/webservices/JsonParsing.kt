package webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.javakotlinpracticals.databinding.ActivityJsonParsingBinding
import org.json.JSONObject
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class JsonParsing : AppCompatActivity() {

    private lateinit var binding: ActivityJsonParsingBinding
    private val url = "https://reqres.in/api/users?page=2"
    var personList = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJsonParsingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread {
            try {
                loadData()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }.start()
    }

    // Display data from API to Recyclerview using JSON
    private fun loadData() {
        val recyclerView = binding.jsonRecyclerView
        val url = URL(url)
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            setRequestProperty("Content-Type", "application/json")
            val response = url.readText()
            val jsonObject = JSONObject(response)
            val jsonarray = jsonObject.getJSONArray("data")
            Log.d("key", jsonarray[0].toString())
            for (i in 0 until jsonarray.length()) {
                val jsonDetails: JSONObject = jsonarray.getJSONObject(i)
                val dataClass = Data()
                dataClass.avatar = jsonDetails.getString("avatar")
                dataClass.email = jsonDetails.getString("email")
                dataClass.firstName = jsonDetails.getString("first_name")
                dataClass.lastName = jsonDetails.getString("last_name")
                personList.add(dataClass)
            }
            runOnUiThread {
                val adapter = JsonParsingAdapter(personList, this@JsonParsing)
                recyclerView.adapter = adapter
                binding.prograssbar1.visibility = View.GONE
            }
            Log.d("Data", personList.toString())
        }
    }
}