package com.captech.teegarcs.mykotlinapplication.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.VISIBLE
import com.captech.teegarcs.mykotlinapplication.R
import com.captech.teegarcs.mykotlinapplication.model.ServiceOffering
import kotlinx.android.synthetic.main.activity_list.*

/**
 * Created by teegarcs on 5/29/17.
 */
class ServiceListActivity : AppCompatActivity(), ServiceListContract {

    companion object{
        val EXTRA_PRACTICE_AREA = "EXTRA_PRACTICE_AREA"
    }

    var detailsPresenter : ServiceListPresenter? = null
    var adapter: ServiceListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ServiceListAdapter(this)
        recyclerView.adapter = adapter

        detailsPresenter = ServiceListPresenter(intent.getParcelableExtra(EXTRA_PRACTICE_AREA))
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        detailsPresenter?.takeView(this)
        recyclerView.visibility = VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        detailsPresenter?.dropView()
    }

    override fun setTitle(title: String) {
      this.title = title
    }

    override fun setList(serviceOfferings: ArrayList<ServiceOffering>) {
        adapter?.setData(serviceOfferings)
    }
}