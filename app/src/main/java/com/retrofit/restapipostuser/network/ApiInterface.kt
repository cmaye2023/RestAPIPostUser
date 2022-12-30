package com.retrofit.restapipostuser.network

import com.retrofit.restapipostuser.data.PostModel
import com.retrofit.restapipostuser.data.UserModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    /**User*/
    @GET("users")
    fun fetchAllUser() : Call<List<UserModel>>






    /**Post*/
    @GET("posts")
    fun fetchAllPosts() : Call<List<PostModel>>

    @POST("posts")
    fun createPost(@Body postModel : PostModel) : Call<PostModel>

    @DELETE("posts/{id}")
    fun deletePost(@Part("id") id : Int) : Call<String>

}