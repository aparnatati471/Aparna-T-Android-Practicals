package uiwidgetse.otherimportantviews

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR
import com.example.javakotlinpracticals.R
import com.example.javakotlinpracticals.databinding.ActivityWebViewBinding

class WebView : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityWebViewBinding
    private lateinit var buttonClickBinding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        buttonClickBinding = DataBindingUtil.setContentView(this, R.layout.activity_web_view)
        buttonClickBinding.setVariable(BR.clickOne, this)
    }

    inner class WebViewClient : android.webkit.WebViewClient() {

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            view?.loadUrl(request.toString())
            return false
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            binding.chipLoadUrl.id -> {
                buttonClickBinding.webView.webViewClient = WebViewClient()
                buttonClickBinding.webView.settings.builtInZoomControls = true
                buttonClickBinding.webView.settings.setSupportZoom(true)
                buttonClickBinding.chipLoadUrl.isCheckable = true
                buttonClickBinding.webView.loadUrl("https://www.google.com")
                buttonClickBinding.chipPdf.isCheckable = false
                buttonClickBinding.chipLoadwebpage.isCheckable = false
                buttonClickBinding.webView.loadUrl("https://www.google.com/")
            }

            binding.chipLoadwebpage.id -> {
                buttonClickBinding.chipLoadwebpage.isCheckable = true
                buttonClickBinding.webView.loadUrl("file:///android_asset/HTMLFiles/index.html")
                buttonClickBinding.chipPdf.isCheckable = false
                buttonClickBinding.chipLoadUrl.isCheckable = false
            }

            binding.chipPdf.id -> {
                buttonClickBinding.chipPdf.isCheckable = true
                buttonClickBinding.webView.settings.javaScriptEnabled = true
                val url = "https://www.tutorialspoint.com/java/java_tutorial.pdf"
                buttonClickBinding.webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
                buttonClickBinding.chipLoadUrl.isCheckable = false
                buttonClickBinding.chipLoadwebpage.isCheckable = false
            }
        }
    }

}