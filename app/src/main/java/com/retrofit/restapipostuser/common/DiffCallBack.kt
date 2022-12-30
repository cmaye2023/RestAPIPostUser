package com.retrofit.restapipostuser.common

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

interface DiffCallBack {
    fun <T> RecyclerView.Adapter<*>.compareItem(old : MutableList<T>,new : MutableList<T>,compare : (T,T) -> Boolean)
    {
        val diff = DiffUtil.calculateDiff(object  : DiffUtil.Callback(){
            override fun getOldListSize(): Int = old.size

            override fun getNewListSize(): Int = new.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return compare(old[oldItemPosition], new[newItemPosition])
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return old[oldItemPosition] == new[newItemPosition]
            }

        })

        diff.dispatchUpdatesTo(this)
    }
}