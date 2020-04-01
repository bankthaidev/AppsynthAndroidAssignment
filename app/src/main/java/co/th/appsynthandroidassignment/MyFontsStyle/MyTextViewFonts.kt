package co.th.appsynthandroidassignment.MyFontsStyle

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView

/**
 * Created by AndroidDeveloper on 9/27/16 AD.
 */
@SuppressLint("AppCompatCustomView")
class MyTextViewFonts : TextView {

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
        attrs.styleAttribute
    }

    constructor(context: Context) : super(context) {
        init()
    }

    private fun init() {
        val tf = Typeface.createFromAsset(context.assets, "fonts/Montserrat-Light.ttf")
        this.includeFontPadding = false
        this.setTextColor(Color.BLACK)
        typeface = tf
    }

}