package webservices


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.javakotlinpracticals.databinding.ActivityRetrofitRecyclerViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRecyclerView : AppCompatActivity() {

    private lateinit var binding: ActivityRetrofitRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
    }

    // Display data from api to recyclerview
    private fun loadData() {
        ApiClient().retrofitBuilder.getlistUsersOne().enqueue(object : Callback<RetroDataClass> {
            override fun onResponse(
                call: Call<RetroDataClass>,
                response: Response<RetroDataClass>
            ) {
                if (response.code() == 200) {
                    val recyclerView = binding.retroRecyclerView
                    response.body()?.let {
                        val responseData = it
                        if (response.body() != null) {
                            val adapter = RetrofitRecyclerViewAdapter(
                                responseData.persondata,
                                this@RetrofitRecyclerView
                            )
                            recyclerView.adapter = adapter
                            binding.prograssbar1.visibility = View.GONE
                            adapter.setOnItemClickListener(object : OnItemClickListener {
                                override fun onItemClick(position: Int) {
                                    val intent = Intent(
                                        this@RetrofitRecyclerView,
                                        DisplaySingleUser::class.java
                                    )
                                    intent.putExtra("userId", responseData.persondata[position].id)
                                    startActivity(intent)
                                }
                            })
                        }
                    }
                }
            }

            override fun onFailure(call: Call<RetroDataClass>, t: Throwable) {
                Toast.makeText(applicationContext, "Fail to load data", Toast.LENGTH_LONG).show()
            }
        })
    }

}