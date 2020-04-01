package co.th.appsynthandroidassignment.view

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import co.th.appsynthandroidassignment.InternetAvailability
import co.th.appsynthandroidassignment.R
import co.th.appsynthandroidassignment.model.InfoNoti
import co.th.appsynthandroidassignment.model.ProfileInfo
import co.th.appsynthandroidassignment.presenter.MainPresenter
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener , IMainITF.View{

    private var mPresenter: IMainITF.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = MainPresenter(this)

        initInstance()
    }

    fun initInstance(){
        bt_refresh.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.bt_refresh ->{
                Snackbar.make(p0,"Please check internet", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun setProfile(mainProfile: ProfileInfo?) {
        Glide.with(this@MainActivity)
            .load(mainProfile!!.avatar)
            .centerCrop()
            .placeholder(R.drawable.ic_person)
            .into(img_profile)
        tv_first_name.text = mainProfile.firstName
        tv_num_likes.text = mainProfile.likes.toString()
        tv_num_followers.text = mainProfile.followers.toString()
        tv_num_following.text = mainProfile.following.toString()
        lv_loading.visibility = View.GONE
        mPresenter!!.loadDateApi(mainProfile.userId)
    }

    override fun setNotilist(mainDetailList: List<InfoNoti>?) {
        recycler_noti.layoutManager = LinearLayoutManager(this)
        recycler_noti.adapter = MainListAdapter(mainDetailList, this)
    }

    override fun setInternet(boolean: Boolean) {
        if(boolean){
            lv_internet.visibility = View.GONE
            lv_loading.visibility = View.VISIBLE
            loadData()
        }else{
            lv_internet.visibility = View.VISIBLE
        }
    }

    private fun loadData() {
        mPresenter!!.loadProfileApi()
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(InternetAvailability(this), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

}
