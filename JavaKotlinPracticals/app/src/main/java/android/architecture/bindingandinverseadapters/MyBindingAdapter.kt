package android.architecture.bindingandinverseadapters

import android.graphics.Color
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import java.lang.Exception


class MyBindingAdapter : ViewModel() {

    companion object {
        private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
        var value = MutableLiveData<String>("0")

        @BindingAdapter("toastMessage")
        @JvmStatic()
        fun runMe(view: View, message: String?) {
            if (message != null)
                Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
        }

        @BindingAdapter("loadImage")
        @JvmStatic()
        fun loadImageOne(view: AppCompatImageView, loadImage: String?) {
            if (!loadImage.isNullOrEmpty())
                Glide.with(view.context).load(loadImage).circleCrop().into(view)
        }

        @BindingAdapter("gettext")
        @JvmStatic()
        fun setTextToTextView(view: AppCompatTextView, text: String) {
            view.text = "Welcome$text"
            view.textSize = 20F
            view.setTextColor(Color.BLUE)
        }

        @BindingAdapter("edtSetText")
        @JvmStatic()
        fun setTextToEditText(view: EditText, text: String) {
            view.text = text.toEditable()
        }

        @InverseBindingAdapter(attribute = "edtSetText")
        @JvmStatic()
        fun setText(view: AppCompatEditText): MutableLiveData<String> {
            val data = view.text.toString()
            try {
                value.value?.let { Log.d("Data:", it) }
                return value
            } catch (exception: Exception) {
                exception.stackTrace
            }
            return value
        }

    }



}

