package uiwidgetsc.recyclerviewandadapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.javakotlinpracticals.R

class ExpandableListViewAdapter internal constructor (
    private val context: Context,
    private val subtitleList: ArrayList<DataClass>
): BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return subtitleList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        return subtitleList[p0].moviedetails.size
    }

    override fun getGroup(p0: Int): Any {
        return subtitleList[p0].moviename
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return subtitleList[p0].moviedetails[p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    @SuppressLint("InflateParams")
    override fun getGroupView(
        titlepos: Int,
        titleisExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var view = convertView
        val title = getGroup(titlepos)
        if(view == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = layoutInflater.inflate(R.layout.list_main_title, null)
        }
        val mainTitle = view?.findViewById<TextView>(R.id.maintitle)
        if (mainTitle != null) {
            mainTitle.text = title.toString()
        }
        return view!!
    }

    @SuppressLint("InflateParams")
    override fun getChildView(
        titlepos: Int,
        subtitlepos: Int,
        islastchild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var view = convertView
        val subtitle = getChild(titlepos, subtitlepos) as String
        if(view == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = layoutInflater.inflate(R.layout.list_sub_title, null)
        }
        val childTitle = view?.findViewById<TextView>(R.id.subtitle)
        if (childTitle != null) {
            childTitle.text = subtitle
        }
        return view!!
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

}