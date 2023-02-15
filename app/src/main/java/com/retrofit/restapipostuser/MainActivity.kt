package com.retrofit.restapipostuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.retrofit.restapipostuser.data.PostModel
import com.retrofit.restapipostuser.data.UserModel
import com.retrofit.restapipostuser.databinding.ActivityMainBinding
import com.retrofit.restapipostuser.viewhelper.HomeAdapter
import com.retrofit.restapipostuser.viewhelper.HomeViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : HomeViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding
    private lateinit var adatper : HomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        bindData()
    }

    private fun setUpRecyclerView()
    {
        with(binding)
        {
            try {
                adatper = HomeAdapter{view,PostModel,action ->
                    when(action)
                    {
                        "onClick" -> Toast.makeText(this@MainActivity, "onclick", Toast.LENGTH_SHORT).show()
                        "onLongClick" -> Toast.makeText(this@MainActivity,"onLongClick",Toast.LENGTH_SHORT).show()
                    }



                }
                recyclerRetrofitTest.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerRetrofitTest.scrollToPosition(10)
                recyclerRetrofitTest.adapter = adatper
            }catch (ex : Exception)
            {
                Toast.makeText(this@MainActivity, ex.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun bindData()
    {
        with(binding)
        {
            try {
                viewModel.fetchAllUser()

                viewModel.userModelListLiveData?.observe(this@MainActivity, Observer {
                    if (it != null && it.isNotEmpty())
                    {
                        adatper.setData(it as MutableList<UserModel>)
                        adatper.notifyDataSetChanged()
                    }else{
                        Toast.makeText(this@MainActivity, "something error!", Toast.LENGTH_SHORT).show()
                    }
                })



//
//                viewModel.postModelListLiveData?.observe(this@MainActivity, Observer {
//                    if (it != null && it.isNotEmpty())
//                    {
//                        adatper.setData(it as MutableList<PostModel>)
//                        adatper.notifyDataSetChanged()
//                    }else{
//                        Toast.makeText(this@MainActivity, "something error!", Toast.LENGTH_SHORT).show()
//                    }
//                })


            }catch (ex : Exception)
            {
                Toast.makeText(this@MainActivity, ex.toString(), Toast.LENGTH_SHORT).show()
            }


        }
    }
}