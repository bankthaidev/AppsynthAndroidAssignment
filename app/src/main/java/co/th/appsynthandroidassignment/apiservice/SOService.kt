package co.th.appsynthandroidassignment.apiservice

import co.th.appsynthandroidassignment.model.InfoNoti
import co.th.appsynthandroidassignment.model.ProfileInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SOService {

    @GET("/api/razir/user/profile")
    fun getProfile(): Call<ProfileInfo>

    @GET("/api/razir/users/{userId}/notifications")
    fun getInfoNoti(@Path("userId") userId: String): Call<List<InfoNoti>>
}