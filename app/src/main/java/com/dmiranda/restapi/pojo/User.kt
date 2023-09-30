package com.dmiranda.restapi.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
 @SerializedName("id")
 @Expose
 var userId: Int? = null

 @SerializedName("name")
 @Expose
 var userName: String? = null

 @SerializedName("email")
 @Expose
 var userEmail: String? = null

 @SerializedName("phone")
 @Expose
 var userPhone: String? = null
}