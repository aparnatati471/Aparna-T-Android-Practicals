package webservices

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

// Interface for API
interface APIInterface {

    @GET("api/users?page= id")
    fun getlistUsers(@Query("pageNo") id: Int): retrofit2.Call<RetroDataClass>

    @GET("/api/users?delay=3")
    fun getlistUsersOne(): retrofit2.Call<RetroDataClass>

    @GET("api/users/{id}")
    fun getSingleUser(@Path("id") id: Int): retrofit2.Call<SingleUserDataclass>

    @POST("/api/users")
    fun addUser(@Body requestData: RequestForAddUser): retrofit2.Call<ResponseForAddUser>

    @PUT("/api/users/{id}")
    fun updateUserData(
        @Path("id") id: Int,
        @Body requestData: RequestForAddUser
    ): retrofit2.Call<ResposeForUpdate>

    @DELETE("/api/users/{id}")
    fun deleteUserData(@Path("id") id: Int): retrofit2.Call<Unit>

    @PATCH("/api/users/{id}")
    fun patchUserData(
        @Path("id") id: Int,
        @Body requestData: RequestForAddUser
    ): retrofit2.Call<ResposeForUpdate>
}

// Interface for ItemClick in recyclerview
interface OnItemClickListener {
    fun onItemClick(position: Int)
}