package uiwidgetsc.recyclerviewandadapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.javakotlinpracticals.databinding.FragmentViewPagerSecondBinding

class ViewPagerSecondFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerSecondBinding.inflate(layoutInflater)
        return binding.root
    }

}