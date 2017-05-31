package com.captech.teegarcs.mykotlinapplication.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.captech.teegarcs.mykotlinapplication.R
import com.captech.teegarcs.mykotlinapplication.model.PracticeArea
import kotlinx.android.synthetic.main.list_view_holder.view.*

/**
 * Created by tgarden on 5/26/17.
 */
class HomeAdapter(val context: Context) : RecyclerView.Adapter<HomeAdapter.PracticeAreaHolder>() {

    var practiceArea: ArrayList<PracticeArea>? = null
    var practiceListener: PracticeListener? = null

    /**
     * Method to set data to the adapter
     */
    fun setData(practiceArea: ArrayList<PracticeArea>, practiceListener: PracticeListener) {
        this.practiceArea = practiceArea
        this.practiceListener = practiceListener
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup?, position: Int): HomeAdapter.PracticeAreaHolder {
        return PracticeAreaHolder(LayoutInflater.from(context).inflate(R.layout.list_view_holder, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: HomeAdapter.PracticeAreaHolder?, position: Int) {
        viewHolder?.bindView(practiceArea?.get(position), practiceListener!!)
    }

    override fun getItemCount(): Int {
        return practiceArea?.size ?: 0
    }

    class PracticeAreaHolder(view: View) : RecyclerView.ViewHolder(view) {

        var practiceListener: PracticeListener? = null

        fun bindView(area: PracticeArea?, practiceListener: PracticeListener) {
            itemView.listImage.setImageURI(area?.imageLink)
            itemView.listTitle.text = area?.name
            itemView.listBody.text = area?.body
            itemView.listSubTitle.text = area?.subTitle
            this.practiceListener = practiceListener
            //in this case, lets force an NPE if something bad happens. You probably would rather have better
            //handling than this, but just for demo purposes
            itemView.setOnClickListener({ practiceListener.practiceSelected(area!!) })
        }
    }

    interface PracticeListener {
        fun practiceSelected(practiceArea: PracticeArea)
    }

}