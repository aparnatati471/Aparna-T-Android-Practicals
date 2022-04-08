package android.architecture.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.javakotlinpracticals.databinding.ActivityCoroutineApicallingBinding
import kotlinx.coroutines.launch
import java.lang.Exception

class CoroutineAPICalling : AppCompatActivity() {

    private lateinit var binding: ActivityCoroutineApicallingBinding
    private lateinit var adapter: CoroutineApiCallingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineApicallingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launch {
            try {
                loadData()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

     //Display data from api to recyclerview
    private suspend fun loadData() {
        val response = ApiClient.retrofitBuilder.getlistUsersOne()
            val recyclerView = binding.retroRecyclerView
            response.body()?.let {
                val responseData = it
                if (response.body() != null) {
                    val adapter = CoroutineApiCallingAdapter(
                        responseData.persondata as ArrayList<Data>,
                        this@CoroutineAPICalling
                    )
                    recyclerView.adapter = adapter
                    binding.prograssbar1.visibility = View.GONE
                }
            }

    }
}