package uiwidgetsc.recyclerviewandadapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.javakotlinpracticals.databinding.FragmentViewPagerFirstBinding

class ViewPagerFirstFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerFirstBinding.inflate(layoutInflater)
        return binding.root
    }

}