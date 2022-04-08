package android.architecture.coroutines

import com.google.gson.annotations.SerializedName

data class Data(
    var avatar: String? = null,
    var email: String? = null,
    @SerializedName("first_name")
    var firstName: String? = null,
    var id: String? = null,
    @SerializedName("last_name")
    var lastName: String? = null
)