package uiwidgetd.activity.intent.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.javakotlinpracticals.R
import android.util.Log

class FragmentOneDemo : Fragment() {

    private fun printLog(s: String) {
        Log.d("FragmentLifeCycle:", s)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        printLog("OnAttach")
    }

    override fun onDetach() {
        super.onDetach()
        printLog("OnDetach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        printLog("OnCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        printLog("OnCreateView")
        return inflater.inflate(R.layout.fragment_one_demo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printLog("OnViewCreated")
    }

    override fun onDestroy() {
        super.onDestroy()
        printLog("OnDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        printLog("OnDestroyView")
    }

    override fun onPause() {
        super.onPause()
        printLog("OnPause")
    }

    override fun onResume() {
        super.onResume()
        printLog("OnResume")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        printLog("OnViewStateResourced")
    }

    override fun onStart() {
        super.onStart()
        printLog("OnStart")
    }

    override fun onStop() {
        super.onStop()
        printLog("OnStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        printLog("OnSaveInstanceState")
    }

}