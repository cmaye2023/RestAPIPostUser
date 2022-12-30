package com.retrofit.restapipostuser.data

data class UserModel(
    var id:Int?=0,
    var name:String ="",
    var username:String?="",
    var email:String?="",
    var address : AddressModel,
    var phone  : String ?= "",
    var website : String ?= "",
    var company : CompanyModel
)