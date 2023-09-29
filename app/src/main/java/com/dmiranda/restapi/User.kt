package com.dmiranda.restapi

import android.provider.ContactsContract.CommonDataKinds.Email

data class User (
    val id: Int,
    val name: String,
    val email: Email,
    val phone: String

)