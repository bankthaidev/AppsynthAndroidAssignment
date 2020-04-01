package co.th.appsynthandroidassignment.apiservice

class ApiUtils {

    val BASE_URL = "https://testapi.io"

    fun getSOService(): SOService? {
        return RetrofitClient.getClient(BASE_URL)!!.create(SOService::class.java)
    }
}