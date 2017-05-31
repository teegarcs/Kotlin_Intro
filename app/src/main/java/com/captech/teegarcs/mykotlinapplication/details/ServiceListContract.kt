package com.captech.teegarcs.mykotlinapplication.details

import com.captech.teegarcs.mykotlinapplication.model.ServiceOffering

/**
 * Created by teegarcs on 5/29/17.
 */
interface ServiceListContract {

    fun setTitle(title : String)
    fun setList(serviceOfferings : ArrayList<ServiceOffering>)
}