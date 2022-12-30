package com.retrofit.restapipostuser.viewhelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.retrofit.restapipostuser.common.DiffCallBack
import com.retrofit.restapipostuser.data.PostModel
import com.retrofit.restapipostuser.databinding.AdapterPostModelBinding
import kotlin.properties.Delegates

class HomeAdapter(private val onItemClick : (View,PostModel,String) -> Unit) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(),DiffCallBack
{
    private lateinit var binding: AdapterPostModelBinding

    private var postModelList : MutableList<PostModel> by Delegates.observable(mutableListOf()){ _, old, new ->
        compareItem(old,new){o,n -> o.id === n.id}
    }

    inner class ViewHolder(private val binding : AdapterPostModelBinding,onItemClick: (View, PostModel, String) -> Unit) : RecyclerView.ViewHolder(binding.root)
    {

        fun bindData(postModel: PostModel)
        {
            with(binding)
            {
                postModelTitle.text = postModel.title

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = AdapterPostModelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(postModelList[position])
    }

    override fun getItemCount(): Int {
        return postModelList.size
    }

    fun setData(list : MutableList<PostModel>)
    {
        this.postModelList = list
    }

}