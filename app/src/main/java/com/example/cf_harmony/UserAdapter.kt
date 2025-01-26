package com.example.cf_harmony

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class UserAdapter(val context: Context, val userList: ArrayList<User>):
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.chatcard, parent, false)
        return UserViewHolder(view)

    }

    override fun getItemCount(): Int {
        return userList.size

    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]

        holder.textpatientid.text = currentUser.patientid
        holder.textcftype.text = currentUser.cftype
        holder.textsymptom.text = currentUser.sym


        holder.itemView.setOnClickListener{
            val intent = Intent(context,ChatActivity::class.java)
            intent.putExtra("patientid", currentUser.patientid)
            intent.putExtra("uid",currentUser.uid)
            intent.putExtra("cftype",currentUser.cftype)
            intent.putExtra("sym",currentUser.sym)


            context.startActivity(intent)
        }
    }

    class  UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textpatientid = itemView.findViewById<TextView>(R.id.txt_patientid)
        val textcftype = itemView.findViewById<TextView>(R.id.cftr_type)
        val textsymptom = itemView.findViewById<TextView>(R.id.symptom)


    }

}