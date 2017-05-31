package com.captech.teegarcs.mykotlinapplication.details

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.captech.teegarcs.mykotlinapplication.R
import com.captech.teegarcs.mykotlinapplication.model.ServiceOffering
import kotlinx.android.synthetic.main.service_list_holder.view.*

/**
 * Created by tgarden on 5/29/17.
 */
class ServiceListAdapter (val context : Context) : RecyclerView.Adapter<ServiceListAdapter.ServiceOfferingHolder>() {

    var serviceOfferings: ArrayList<ServiceOffering>? = null

    /**
     * Method to set data to the adapter
     */
    fun setData(serviceOfferings: ArrayList<ServiceOffering>){
        this.serviceOfferings = serviceOfferings
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup?, position: Int): ServiceOfferingHolder {
        return ServiceOfferingHolder(LayoutInflater.from(context).inflate(R.layout.service_list_holder, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ServiceOfferingHolder?, position: Int) {
        viewHolder?.bindView(serviceOfferings?.get(position))
    }

    override fun getItemCount(): Int {
        return serviceOfferings?.size ?:0
    }

    class ServiceOfferingHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindView(offering : ServiceOffering?){
            itemView.listImage.setImageURI(offering?.imageLink)
            itemView.listTitle.text = offering?.name
            itemView.listBody.text = offering?.body
            itemView.listSubTitle.text = offering?.subTitle
        }
    }

}