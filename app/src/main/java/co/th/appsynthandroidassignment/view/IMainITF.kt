package co.th.appsynthandroidassignment.view

import co.th.appsynthandroidassignment.base.BasePresenter
import co.th.appsynthandroidassignment.base.BaseView
import co.th.appsynthandroidassignment.model.InfoNoti
import co.th.appsynthandroidassignment.model.ProfileInfo

interface IMainITF {

    interface View : BaseView<Presenter?> {
        fun setProfile(mainProfile : ProfileInfo?)
        fun setNotilist(mainDetailList : List<InfoNoti>?)
        fun setInternet(boolean: Boolean)
    }

    interface Presenter : BasePresenter {
        fun loadProfileApi()
        fun loadDateApi(string: String)
    }
}