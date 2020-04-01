package co.th.appsynthandroidassignment.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProfileInfo {
    @SerializedName("userId")
    @Expose
    lateinit var userId: String

    @SerializedName("firstName")
    @Expose
    lateinit var firstName: String

    @SerializedName("lastName")
    @Expose
    lateinit var lastName: String

    @SerializedName("avatar")
    @Expose
    lateinit var avatar: String

    @SerializedName("followers")
    @Expose
    var followers: Int = 0

    @SerializedName("following")
    @Expose
    var following: Int = 0

    @SerializedName("likes")
    @Expose
    var likes: Int = 0
}