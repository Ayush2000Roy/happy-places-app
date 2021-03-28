package com.example.happyplaces.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.happyplaces.R
import com.example.happyplaces.activities.AddHappyPlaceActivity
import com.example.happyplaces.activities.MainActivity
import com.example.happyplaces.database.DatabaseHandler
import com.example.happyplaces.models.HappyPlaceModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.item_happy_place.view.*

open class HappyPlacesAdapter (
    private val context: Context,
    private val list: ArrayList<HappyPlaceModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    
    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_happy_place, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = list[position]
        if (holder is MyViewHolder){
            holder.itemView.civ_place_image.setImageURI(Uri.parse(model.image))
            holder.itemView.tv_title.text = model.title
            holder.itemView.tv_description.text = model.description
            
            holder.itemView.setOnClickListener{
                if (onClickListener != null){
                    onClickListener!!.onClick(position, model)
                }
            }
        }
    }

    fun removeAt(position: Int){
        val dbHandler = DatabaseHandler(context)
        val isDeleted = dbHandler.deleteHappyPlace(list[position])
        if (isDeleted > 0){
            list.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun notifyEditItem(activity: Activity, position: Int, requestCode: Int){
        val intent = Intent(context, AddHappyPlaceActivity::class.java)
        intent.putExtra(MainActivity.EXTRA_PLACE_DETAILS, list[position])
        activity.startActivityForResult(intent, requestCode)
        notifyItemChanged(position)
    }
    
    fun setOnClickListener(onClickListener: OnClickListener){
        this.onClickListener = onClickListener
    }
    
    interface OnClickListener{
        fun onClick(position: Int, model: HappyPlaceModel)
    }

    private class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

}