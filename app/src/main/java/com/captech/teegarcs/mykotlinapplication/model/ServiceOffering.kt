package com.captech.teegarcs.mykotlinapplication.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by teegarcs on 5/24/17.
 */
data class ServiceOffering(val name : String, val imageLink : String, val subTitle:String, val body: String) : Parcelable {

    /**
     * Companion object is used to defined static members to the class..
     * in our case the creator.
     */
    companion object {
        /**
         * Parcelable creator.
         *
         * @JvmField used make the creator implementation visible as a field to Java.
         *
         */
        @JvmField
        val CREATOR = object : Parcelable.Creator<ServiceOffering> {
            override fun createFromParcel(source: Parcel): ServiceOffering? = ServiceOffering(source)
            override fun newArray(size: Int): Array<out ServiceOffering?> = arrayOfNulls(size)
        }
    }

    /**
     * Secondary constructor for the parcelable
     */
    protected constructor(parcelIn: Parcel) : this(parcelIn.readString(), parcelIn.readString(),
            parcelIn.readString(), parcelIn.readString())

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeString(imageLink)
        dest?.writeString(subTitle)
        dest?.writeString(body)
    }

    override fun describeContents() = 0
}