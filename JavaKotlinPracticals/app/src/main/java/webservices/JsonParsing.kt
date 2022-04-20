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
    private lateinit var adapter: JsonParsingAdapter

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
            val jsonArray = jsonObject.getJSONArray("data")
            Log.d("key", jsonArray[0].toString())
            for (i in 0 until jsonArray.length()) {
                val jsonDetails: JSONObject = jsonArray.getJSONObject(i)
                val dataClass = Data(
                                        jsonDetails.getString("avatar"),
                                        jsonDetails.getString("email"),
                                        jsonDetails.getString("first_name"),
                                        jsonDetails.getString("last_name")
                                    )
                personList.add(dataClass)
            }
            runOnUiThread {
                adapter = JsonParsingAdapter(personList, this@JsonParsing)
                recyclerView.adapter = adapter
                binding.prograssbar1.visibility = View.GONE
            }
            Log.d("Data", personList.toString())
        }
    }
}