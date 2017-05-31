package com.captech.teegarcs.mykotlinapplication.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import com.captech.teegarcs.mykotlinapplication.R
import com.captech.teegarcs.mykotlinapplication.common.AssetLoader.AssetLoaderManager
import com.captech.teegarcs.mykotlinapplication.details.ServiceListActivity
import com.captech.teegarcs.mykotlinapplication.model.PracticeArea
import kotlinx.android.synthetic.main.activity_list.*

/**
 * Created by teegarcs on 5/24/17.
 *
 * HomeActivity instance which extends AppCompat and implements HomeContract
 */

class HomeActivity : AppCompatActivity(), HomeContract, HomeAdapter.PracticeListener {

    var homePresenter: HomePresenter? = null
    var adapter: HomeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        homePresenter = HomePresenter(AssetLoaderManager(this))

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HomeAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }

    override fun practiceSelected(practiceArea: PracticeArea) {
        val forward = Intent(this, ServiceListActivity::class.java)
        forward.putExtra(ServiceListActivity.EXTRA_PRACTICE_AREA, practiceArea)
        startActivity(forward)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        homePresenter?.takeView(this)
    }

    override fun onDestroy() {
        homePresenter?.dropView()
        super.onDestroy()
    }

    override fun setData(practiceAreaData: ArrayList<PracticeArea>) {
        adapter?.setData(practiceAreaData, this)
        recyclerView.visibility = VISIBLE
        progressBar.visibility = GONE
    }

    override fun showLoader() {
        recyclerView.visibility = GONE
        progressBar.visibility = VISIBLE
        errorView.visibility = GONE
    }

    override fun showError() {
        progressBar.visibility = GONE
        errorView.visibility = VISIBLE
    }

}
