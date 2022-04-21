package webservices

import com.google.gson.annotations.SerializedName

data class RetroDataClass(
    @SerializedName("data")
    val persondata: List<Data>,
    val page: Int,
    @SerializedName("per_page")
    val perpage: Int,
    val support: Support,
    val total: Int,
    @SerializedName("total_pages")
    val totalpages: Int
)

