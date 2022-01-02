package com.example.music_shop

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ListMenuItemView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter (val list: ArrayList<Order>):
    RecyclerView.Adapter<OrderAdapter.OrderHolder>(){
    inner class OrderHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var tvItemImage: ImageView? = null
        var tvOrderQuantity: TextView? = null
        var tvItemUser: TextView? = null
        var tvItemname: TextView? = null
        var tvItemPrice: TextView? = null
        var tvImage:ImageView? = null



        init {
            tvItemImage = itemView.findViewById(R.id.itemImage)
            tvOrderQuantity = itemView.findViewById(R.id.tvItemQuantity)
            tvItemUser = itemView.findViewById(R.id.tvItemUser)
            tvItemname = itemView.findViewById(R.id.tvItemName)
            tvItemPrice = itemView.findViewById(R.id.tvItemPrice)
            tvImage= itemView.findViewById(R.id.imageView4)
//            tvImage?.setOnClickListener {
//                list.removeAt(position)
//                notifyItemChanged(position)
//                notifyItemRangeRemoved(position, 1)
//                notifyDataSetChanged()
//
//            }
            }



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHolder {
     val orderView = LayoutInflater.from(parent.context).inflate(R.layout.inter,parent,false)
        return OrderHolder(orderView)
    }

    override fun onBindViewHolder(holder: OrderHolder, position: Int) {
        holder.tvItemname?.text = list.get(position).ItemName
        holder.tvOrderQuantity?.text = list.get(position).orderKolich.toString()
        holder.tvItemImage?.setImageResource(list.get(position).imageId)
        holder.tvItemUser?.text = list.get(position).clientName
        holder.tvItemPrice?.text = list.get(position).price.toString()
        holder.tvImage
        holder.tvImage?.setOnClickListener {
            Remove.list.removeAt(position)
//            MainActivity().getStaticField().removeAt(position)
            list.removeAt(position)
            notifyItemRemoved(position)
            notifyItemChanged(position)
            notifyItemRangeRemoved(position, 1)
            notifyDataSetChanged()

        }

    }

    override fun getItemCount(): Int {
          return list.size
    }

}