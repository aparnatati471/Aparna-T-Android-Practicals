package webservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// API Base URL
private const val BASE_URL = "https://reqres.in/"

class ApiClient {

    // Retrofit Object Instantiation using singleton object pattern
    val retrofitBuilder: APIInterface by lazy {
        return@lazy Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIInterface::class.java)
    }

}

