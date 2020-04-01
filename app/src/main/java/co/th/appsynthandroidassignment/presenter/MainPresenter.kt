package co.th.appsynthandroidassignment.presenter

import co.th.appsynthandroidassignment.apiservice.ApiUtils
import co.th.appsynthandroidassignment.model.InfoNoti
import co.th.appsynthandroidassignment.model.ProfileInfo
import co.th.appsynthandroidassignment.view.IMainITF
import co.th.appsynthandroidassignment.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(mainActivity: MainActivity) : IMainITF.Presenter {

    private var apiService: ApiUtils? = ApiUtils()
    var mainView: IMainITF.View? = mainActivity

    override fun loadProfileApi() {
        apiService!!.getSOService()!!.getProfile().enqueue(object : Callback<ProfileInfo> {
            override fun onResponse(call: Call<ProfileInfo>, response: Response<ProfileInfo>) {
                mainView!!.setProfile(response.body())
            }

            override fun onFailure(call: Call<ProfileInfo>, t: Throwable) {
            }

        })
    }

    override fun loadDateApi(userid:String) {
        apiService!!.getSOService()!!.getInfoNoti(userid).enqueue(object : Callback<List<InfoNoti>> {

            override fun onResponse(call: Call<List<InfoNoti>>, response: Response<List<InfoNoti>>) {
                mainView!!.setNotilist(response.body())
            }

            override fun onFailure(call: Call<List<InfoNoti>>, t: Throwable) {
            }

        })
    }
}
