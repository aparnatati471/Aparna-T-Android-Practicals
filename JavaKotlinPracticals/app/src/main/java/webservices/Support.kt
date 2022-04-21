package webservices

data class Support(
    val text: String,
    val url: String
)

data class SingleUserDataclass(
    val data: Data,
    val support: Support
)

data class RequestForAddUser(
    val name: String,
    val job: String
)

data class ResponseForAddUser(
    val name: String,
    val job: String,
    var id: Int,
    var createdAt: String
)

data class ResposeForUpdate(
    val name: String,
    val job: String,
    val updatedAt: String
)
