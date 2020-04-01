package co.th.appsynthandroidassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class InfoNoti {
    @SerializedName("created")
    @Expose
    lateinit var created: String

    @SerializedName("text")
    @Expose
    lateinit var text: String
}