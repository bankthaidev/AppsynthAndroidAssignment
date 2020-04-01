package co.th.appsynthandroidassignment.MyFontsStyle

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.Button

@SuppressLint("AppCompatCustomView")
class MyButtonFontsBold : Button {


    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context) : super(context) {
        init()

    }

    private fun init() {
        val tf = Typeface.createFromAsset(context.assets, "fonts/Montserrat-Medium.ttf")
        typeface = tf
    }

}
