package uiwidgetsc.recyclerviewandadapters

data class DataClass(val moviename: String, val moviedetails: List<String>) {

    private var nestedList: List<String> = moviedetails
    private var itemText: String = moviename
    private var isExpandable = false

    fun setExpandable(expandable: Boolean) {
        isExpandable = expandable
    }

    fun getNestedList(): List<String> {
        return nestedList
    }

    fun getItemText(): String {
        return itemText
    }

    fun isExpandable(): Boolean {
        return isExpandable
    }

}

