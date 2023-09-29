package com.dmiranda.restapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTextView.text = user.name
        holder.emailTextView.text = user.email.toString()
        holder.phoneTextView.text = user.phone
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        val phoneTextView: TextView = itemView.findViewById(R.id.phoneTextView)
    }
}
