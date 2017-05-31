package com.captech.teegarcs.mykotlinapplication.details

import com.captech.teegarcs.mykotlinapplication.common.BasePresenter
import com.captech.teegarcs.mykotlinapplication.model.PracticeArea

/**
 * Created by teegarcs on 5/29/17.
 */
class ServiceListPresenter(val practiceArea: PracticeArea) : BasePresenter<ServiceListContract>() {

    override fun onViewReceived() {
        super.onViewReceived()
        view?.setTitle(practiceArea.name)
        view?.setList(practiceArea.serviceOfferings)
    }

}