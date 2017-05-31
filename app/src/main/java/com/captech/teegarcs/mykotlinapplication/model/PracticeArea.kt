package com.captech.teegarcs.mykotlinapplication.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by teegarcs on 5/25/17.
 */
data class PracticeArea(val name: String, val imageLink: String,
                        val subTitle: String, val body: String,
                        val serviceOfferings: ArrayList<ServiceOffering>) : Parcelable {

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
        val CREATOR = object : Parcelable.Creator<PracticeArea> {
            override fun createFromParcel(source: Parcel): PracticeArea? = PracticeArea(source)
            override fun newArray(size: Int): Array<out PracticeArea?> = arrayOfNulls(size)
        }
    }

    /**
     * Secondary constructor for the parcelable
     */

    protected constructor(parcelIn: Parcel) : this(parcelIn.readString(), parcelIn.readString(),
            parcelIn.readString(), parcelIn.readString(), parcelIn.createTypedArrayList(ServiceOffering.CREATOR))


    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(name)
        dest?.writeString(imageLink)
        dest?.writeString(subTitle)
        dest?.writeString(body)
        dest?.writeTypedList(serviceOfferings)
    }

    override fun describeContents() = 0
}