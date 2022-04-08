package design.support.library

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uiwidgetsc.recyclerviewandadapters.ViewPagerFirstFragment
import uiwidgetsc.recyclerviewandadapters.ViewPagerSecondFragment

class TabLayoutAdapter(
    fragment: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragment, lifecycle) {

    companion object {
        val title = arrayOf("CHATS", "STATUS", "CALLS")
    }

    override fun getItemCount(): Int {
        return title.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> WhatsAppChats()
            1 -> ViewPagerSecondFragment()
            2 -> ViewPagerSecondFragment()
            else -> WhatsAppChats()
        }
    }

}