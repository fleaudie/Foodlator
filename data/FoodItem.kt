package com.fleaudie.foodlator.data

import android.os.Parcel
import android.os.Parcelable

data class FoodItem (
    val foodName: String,
    val nutrients: Nutrients
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readParcelable(Nutrients::class.java.classLoader) ?: Nutrients(0.0, 0, 0.0, 0.0, 0.0)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(foodName)
        parcel.writeParcelable(nutrients, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FoodItem> {
        override fun createFromParcel(parcel: Parcel): FoodItem {
            return FoodItem(parcel)
        }

        override fun newArray(size: Int): Array<FoodItem?> {
            return arrayOfNulls(size)
        }
    }
}