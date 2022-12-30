package com.retrofit.restapipostuser.viewhelper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.retrofit.restapipostuser.data.PostModel
import com.retrofit.restapipostuser.data.UserModel
import com.retrofit.restapipostuser.network.ApiClient
import com.retrofit.restapipostuser.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {

    private var apiInterface: ApiInterface?=null

    init {
        apiInterface = ApiClient.getApiClient().create(ApiInterface::class.java)
    }

    /**User*/

    fun fetchAllUser():LiveData<List<UserModel>?>{
        val data = MutableLiveData<List<UserModel>?>()

        apiInterface?.fetchAllUser()?.enqueue(object : Callback<List<UserModel>>{

            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<UserModel>>,
                response: Response<List<UserModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }

            }
        })

        return data

    }















    /**Post*/

    fun fetchAllPosts():LiveData<List<PostModel>>{
        val data = MutableLiveData<List<PostModel>>()

        apiInterface?.fetchAllPosts()?.enqueue(object : Callback<List<PostModel>>{

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }

            }
        })

        return data

    }

    fun createPost(postModel: PostModel):LiveData<PostModel>{
        val data = MutableLiveData<PostModel>()

        apiInterface?.createPost(postModel)?.enqueue(object : Callback<PostModel>{
            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                val res = response.body()
                if (response.code() == 201 && res!=null){
                    data.value = res
                }else{
                    data.value = null
                }
            }
        })

        return data

    }

    fun deletePost(id:Int):LiveData<Boolean>{
        val data = MutableLiveData<Boolean>()

        apiInterface?.deletePost(id)?.enqueue(object : Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                data.value = false
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                data.value = response.code() == 200
            }
        })

        return data

    }

}