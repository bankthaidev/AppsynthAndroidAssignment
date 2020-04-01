package co.th.appsynthandroidassignment.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.th.appsynthandroidassignment.R
import co.th.appsynthandroidassignment.Utils
import co.th.appsynthandroidassignment.model.InfoNoti
import kotlinx.android.synthetic.main.custom_recycler_view.view.*

class MainListAdapter(val items : List<InfoNoti>?, val context: Context) : RecyclerView.Adapter<ViewHolderHis>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHis {
        return ViewHolderHis(LayoutInflater.from(context).inflate(R.layout.custom_recycler_view, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderHis, position: Int) {
        holder.tv_text.text = items?.get(position)!!.text
        holder.tv_create.text = Utils(context).convertTime(items[position].created)
        if ((position % 2) == 0) {
            holder.lv_box_info.setBackgroundResource(R.color.white)
        }else{
            holder.lv_box_info.setBackgroundResource(R.color.gray)
        }
    }

    override fun getItemCount(): Int {
        return items!!.size
    }

}

class ViewHolderHis (view: View) : RecyclerView.ViewHolder(view) {
    val tv_text = view.tv_text
    val tv_create = view.tv_create
    val lv_box_info = view.lv_box_info
}
