package com.lapin.otakushopukraine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ListAdapter: BaseRecyclerViewAdapter<Product>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myHolder = holder as? MyViewHolder
        myHolder?.setUpView(product = getItem(position))
    }

    inner class MyViewHolder (view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val imageView: ImageView = view.findViewById(R.id.image_view)
        private val textView: TextView = view.findViewById(R.id.text_view)
        private val priceView: TextView = view.findViewById(R.id.Price_View)

        init {
            view.setOnClickListener(this)
        }

        fun setUpView(product: Product?) {
            textView.text = product?.name
            priceView.text = "${product?.price.toString()} грн."
            Picasso.get().load(product?.imageUrl).into(imageView);
        }

        override fun onClick(v: View?) {
            itemClickListener?.onItemClick(adapterPosition, v)
        }
    }
}