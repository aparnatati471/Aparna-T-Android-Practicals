package uiwidgetsc.recyclerviewandadapters

import java.util.ArrayList

class DataModel(movieOne: ArrayList<String>, moviesItem: String) {

    private var nestedList: ArrayList<String> = movieOne
    private var itemText: String = moviesItem
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