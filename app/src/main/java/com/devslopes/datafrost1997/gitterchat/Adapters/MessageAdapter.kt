package com.devslopes.datafrost1997.gitterchat.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.devslopes.datafrost1997.gitterchat.Model.Message
import com.devslopes.datafrost1997.gitterchat.R

/**
 * Created by datafrost1997 on 28/10/17.
 */
class MessageAdapter(val context: Context, val messages: ArrayList<Message>) : RecyclerView.Adapter<MessageAdapter.ViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.message_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    }

    override fun getItemCount(): Int {
        return messages.count()
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val userImage = itemView?.findViewById<ImageView>(R.id.messageUserImage)
        val timeStamp = itemView?.findViewById<TextView>(R.id.timeStamplbl)
        val userName = itemView?.findViewById<TextView>(R.id.messageUserNamelbl)
        val messageBody = itemView?.findViewById<TextView>(R.id.messageBodylbl)

        fun bindMessage(context: Context, message: Message) {
            val resourceId = context.resources.getIdentifier(message.userAvatar, "drawable", context.packageName)
            userImage?.setImageResource(resourceId)

        }
    }
}