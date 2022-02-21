package uiwidgetsc.recyclerviewandadapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragment: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragment, lifecycle) {

    private val title = arrayOf("Recent", "My Favourites")

    override fun getItemCount(): Int {
        return title.size
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0 -> return ViewPagerFirstFragment()
            1 -> return ViewPagerSecondFragment()
        }
        return ViewPagerFirstFragment()
    }

}