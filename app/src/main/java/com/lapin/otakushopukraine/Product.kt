package com.lapin.otakushopukraine

import android.os.Parcel
import android.os.Parcelable

data class Product(val name: String,val price:Float,val description:String?,val imageUrl:String) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()!!, parcel.readFloat(), parcel.readString()!!,parcel.readString()!!)
    constructor(product: DownloadProduct) : this(product.name, product.price, product.description,product.imageUrl)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeFloat(price)
        parcel.writeString(description)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}