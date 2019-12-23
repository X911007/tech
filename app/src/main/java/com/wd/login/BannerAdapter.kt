package com.wd.login

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * author: Xuexiandong
 * data: 2019/12/21 12:12:00
 * function：BannerAdapter适配器
 */
class BannerAdapter(private var list: List<BeanbannerShow.ResultBean>, var context: Context) :
    RecyclerView.Adapter<BannerAdapter.ViewHoldershdz>() {

    private var viewHoldershdz: ViewHoldershdz? = null

    //加载布局
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldershdz {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        viewHoldershdz = ViewHoldershdz(view)
        return viewHoldershdz as ViewHoldershdz
    }

    override fun getItemCount(): Int {
        return list.size

    }

    //加载数据
    override fun onBindViewHolder(holder: BannerAdapter.ViewHoldershdz, position: Int) {
        //文字
        holder.wz.text = list[position].title
        //图片
        Glide.with(context)
            .load(list[position].imageUrl)
            .into(holder.img)

    }

    inner class ViewHoldershdz(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wz: TextView
        val img: ImageView

        init {
            wz = itemView.findViewById(R.id.item_text)
            img = itemView.findViewById(R.id.item_img)
        }
    }
}