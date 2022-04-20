package webservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.javakotlinpracticals.databinding.ActivityGsonParsingBinding
import com.google.gson.Gson
import org.json.JSONObject
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class GsonParsing : AppCompatActivity() {

    private lateinit var binding: ActivityGsonParsingBinding
    private val url = "https://reqres.in/api/users?page=2"
    var personList = ArrayList<Data>()
    private lateinit var adapter: JsonParsingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGsonParsingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread {
            try {
                loadData()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }.start()
    }

    // Display data from API to Recyclerview using GSON
    private fun loadData() {
        val recyclerView = binding.gsonRecyclerView
        val url = URL(url)
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            setRequestProperty("Content-Type", "application/json")
            val responseData = url.readText()
            val jsonObject = JSONObject(responseData)
            val jsonArray = jsonObject.getJSONArray("data")
            for (i in 0 until jsonArray.length()) {
                val gsonData = Gson().fromJson(jsonArray.getString(i), Data::class.java)
                val jsonDetails: JSONObject = jsonArray.getJSONObject(i)
                gsonData.avatar = jsonDetails.getString("avatar")
                gsonData.email = jsonDetails.getString("email")
                gsonData.firstName = jsonDetails.getString("first_name")
                gsonData.lastName = jsonDetails.getString("last_name")
                personList.add(gsonData)
            }
            runOnUiThread {
                adapter = JsonParsingAdapter(personList, this@GsonParsing)
                recyclerView.adapter = adapter
                binding.prograssbar1.visibility = View.GONE
            }
        }
    }

}