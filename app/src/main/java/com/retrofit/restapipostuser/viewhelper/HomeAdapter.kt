package com.retrofit.restapipostuser.viewhelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.retrofit.restapipostuser.common.DiffCallBack
import com.retrofit.restapipostuser.data.UserModel
import com.retrofit.restapipostuser.databinding.AdapterPostModelBinding
import kotlin.properties.Delegates

class HomeAdapter(private val onItemClick : (View,UserModel,String) -> Unit) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(),DiffCallBack
{
    private lateinit var binding: AdapterPostModelBinding

    private var userModelList : MutableList<UserModel> by Delegates.observable(mutableListOf()){ _, old, new ->
        compareItem(old,new){o,n -> o.id === n.id}
    }

    inner class ViewHolder(private val binding : AdapterPostModelBinding,onItemClick: (View, UserModel, String) -> Unit) : RecyclerView.ViewHolder(binding.root)
    {
        lateinit var userModel :UserModel
        init {
            with(binding)
            {
                userNameCard.setOnClickListener {
                    onItemClick(userNameCard,userModel,"onClick")
                }

                userNameCard.setOnLongClickListener{
                    onItemClick(userNameCard,userModel,"onLongClick")
                    true
                }
                userNameCard.scrollTo(-1,-1)

            }
        }

        fun bindData(data: UserModel)
        {
            with(binding)
            {
                userModel = data
                userModelName.text = userModel.name
                userModelEmail.text = userModel.email
                userModelPhone.text = userModel.phone
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = AdapterPostModelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(userModelList[position])
    }

    override fun getItemCount(): Int {
        return userModelList.size
    }

    fun setData(list : MutableList<UserModel>)
    {
        this.userModelList = list
    }

}