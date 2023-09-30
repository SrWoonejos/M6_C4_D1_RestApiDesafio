package com.dmiranda.restapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dmiranda.restapi.R
import com.dmiranda.restapi.pojo.User
import java.util.ArrayList

class UserAdapter(val data: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mName: TextView = itemView.findViewById(R.id.txtUserName)
        val mEmail: TextView = itemView.findViewById(R.id.txtUserEmail)
        val mPhone: TextView = itemView.findViewById(R.id.txtUserPhone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.users_list_item, parent, false)
        return CustomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.mName.text = data[position].userName
        holder.mEmail.text = data[position].userEmail
        holder.mPhone.text = data[position].userPhone
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

