package co.th.appsynthandroidassignment

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import co.th.appsynthandroidassignment.view.IMainITF
import co.th.appsynthandroidassignment.view.MainActivity

class InternetAvailability(mainActivity: MainActivity) : BroadcastReceiver(){

    var mainView: IMainITF.View? = mainActivity

    override fun onReceive(context: Context, intent: Intent) {

        if (isConnected(context)) {
            setBoolean(true)
        } else {
            setBoolean(false)
        }
    }

    fun isConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        val mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
        return wifiInfo != null && wifiInfo.isConnected || mobileInfo != null && mobileInfo.isConnected
    }

    fun setBoolean(boolean: Boolean) {
        mainView!!.setInternet(boolean)
    }


}
