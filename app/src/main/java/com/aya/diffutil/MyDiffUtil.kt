package com.aya.diffutil

import androidx.recyclerview.widget.DiffUtil


class MyDiffUtil(
    private val oldList : List<Language>,
    private val newList : List<Language>
) :DiffUtil.Callback() {

    override fun getOldListSize(): Int {

        return oldList.size
    }

    override fun getNewListSize(): Int {

        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return when{
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            oldList[oldItemPosition].name != newList[newItemPosition].name -> false
            oldList[oldItemPosition].exp != newList[newItemPosition].exp -> false
            else -> true
        }
    }
}
