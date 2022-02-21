package uiwidgetsc.recyclerviewandadapters

data class MoviesItem(
    val name: String,
    val realname: String,
    val team: String,
    val firstappearance: String,
    val createdby: String,
    val publisher: String,
    val bio: String,
    var expandable: Boolean = false
)