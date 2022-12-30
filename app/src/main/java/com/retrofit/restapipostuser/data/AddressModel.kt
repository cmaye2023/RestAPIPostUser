package com.retrofit.restapipostuser.data

data class AddressModel(
    var street:String ?="",
    var suite:String ?= "",
    var city:String?="",
    var zipcode:String?="",
    var geo:GPSModel
    )