package uiwidgets

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter (fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0-> ChatsFragment()
            1-> StatusFragment()
            else-> {
                return CallsFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0-> "CHATS"
            1-> "STATUS"
            else-> {
                "CALLS"
            }
        }
    }

}