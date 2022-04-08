package android.architecture.coroutines

import retrofit2.http.GET

interface APIInterface {

    @GET("/api/users?delay=3")
    suspend fun getlistUsersOne(): retrofit2.Response<DataClass>

}