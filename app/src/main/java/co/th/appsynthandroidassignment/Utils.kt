package co.th.appsynthandroidassignment

import android.annotation.SuppressLint
import android.content.Context
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Utils(context: Context) {

    @SuppressLint("SimpleDateFormat")
    fun convertTime(stringData: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        sdf.timeZone = TimeZone.getTimeZone("GMT")
        val output = SimpleDateFormat("dd MMM yyyy hh:mm aaa")
        var data = Date()
        try {
            data = sdf.parse(stringData)
            data.date = data.date
        } catch (e: ParseException) {
        }
        return output.format(data)
    }
}