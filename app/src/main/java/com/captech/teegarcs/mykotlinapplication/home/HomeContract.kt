package com.captech.teegarcs.mykotlinapplication.home

import com.captech.teegarcs.mykotlinapplication.model.PracticeArea

/**
 * Created by teegarcs on 5/24/17.
 */
interface HomeContract {

    fun showError()
    fun showLoader()
    fun setData(practiceAreaData : ArrayList<PracticeArea>)
}