package com.fleaudie.foodlator.data

import android.os.Parcel
import android.os.Parcelable

data class Nutrients(
    val carbs: Double,
    val calories: Int,
    val fat: Double,
    val fiber: Double,
    val protein: Double
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(carbs)
        parcel.writeInt(calories)
        parcel.writeDouble(fat)
        parcel.writeDouble(fiber)
        parcel.writeDouble(protein)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Nutrients> {
        override fun createFromParcel(parcel: Parcel): Nutrients {
            return Nutrients(parcel)
        }

        override fun newArray(size: Int): Array<Nutrients?> {
            return arrayOfNulls(size)
        }
    }
}
