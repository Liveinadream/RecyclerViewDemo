package com.ztn.recyclerviewdemo.game.adppter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.ztn.recyclerviewdemo.R
import com.ztn.recyclerviewdemo.game.GameBean

/**
 * Created by 冒险者ztn on 2019/3/7.
 * game 的 item 样式展示
 */
class GameRecyclerViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView = itemView.findViewById(R.id.ge_zi)

    fun initView(data: GameBean) {

        if (!data.gz.first && !data.gz.second && !data.gz.third) {
            imageView.setImageResource(R.drawable.ge_zi_not_has)
        } else {
            imageView.setImageResource(R.drawable.ge_zi_has)
        }
    }

}

