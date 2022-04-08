package android.architecture.coroutines

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://reqres.in/"

class ApiClient {

    companion object {
        // Retrofit Object Instantiation using singleton object pattern
        val retrofitBuilder: APIInterface by lazy {
            return@lazy Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIInterface::class.java)
        }

    }

}