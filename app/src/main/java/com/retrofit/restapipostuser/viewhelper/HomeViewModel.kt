package com.retrofit.restapipostuser.viewhelper

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.retrofit.restapipostuser.data.PostModel
import com.retrofit.restapipostuser.data.UserModel


class HomeViewModel(application: Application): AndroidViewModel(application){

    private var homeRepository:HomeRepository?=null

    /**user*/
    var userModelListLiveData : LiveData<List<UserModel>?> ?=null
    fun fetchAllUser(){
        userModelListLiveData = homeRepository?.fetchAllUser()
    }





    /**post*/
    var postModelListLiveData : LiveData<List<PostModel>>?=null
    var createPostLiveData:LiveData<PostModel>?=null
    var deletePostLiveData:LiveData<Boolean>?=null

    fun fetchAllPosts(){
        postModelListLiveData = homeRepository?.fetchAllPosts()
    }

    fun createPost(postModel: PostModel){
        createPostLiveData = homeRepository?.createPost(postModel)
    }

    fun deletePost(id:Int){
        deletePostLiveData = homeRepository?.deletePost(id)
    }




    init {
        homeRepository = HomeRepository()
        /**user*/
        userModelListLiveData = MutableLiveData()




        /**post*/
        postModelListLiveData = MutableLiveData()
        createPostLiveData = MutableLiveData()
        deletePostLiveData = MutableLiveData()
    }


}