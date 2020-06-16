package com.example.githubtrending.presentation

import android.view.View
import com.example.githubtrending.BR
import com.example.githubtrending.R
import com.example.githubtrending.domain.model.GitTrendingModel
import com.example.githubtrending.presentation.util.convertDpToInt
import com.example.githubtrending.presentation.util.loadCircularAvatar
import com.example.githubtrending.presentation.util.setLanguageIcon
import com.mmicu.commonadapter.CommonItemHolder
import kotlinx.android.synthetic.main.item_trend_list.view.*

class TrendingItemHolder(
    override var data: GitTrendingModel?,
    override var layoutId: Int = R.layout.item_trend_list,
    override var variableId: Int? = BR.data
) : CommonItemHolder<GitTrendingModel> {

    override fun onBindViewHolder(itemView: View) {
        super.onBindViewHolder(itemView)

        itemView.avatar.loadCircularAvatar(data?.avatar ?: "")

        data?.languageColor?.let {
            itemView.language.setLanguageIcon(it, 4f.convertDpToInt(itemView.context))
        }
    }

}