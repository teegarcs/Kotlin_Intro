package com.captech.teegarcs.mykotlinapplication.home

import com.captech.teegarcs.mykotlinapplication.common.AssetLoader.AssetLoader
import com.captech.teegarcs.mykotlinapplication.common.BasePresenter
import com.captech.teegarcs.mykotlinapplication.model.PracticeArea
import com.google.gson.reflect.TypeToken
import rx.Subscription


/**
 * Created by teegarcs on 5/24/17.
 *
 * Home Presenter instance which extends BasePresenter with type argument of "Home Contract"
 */
class HomePresenter(val assetLoader: AssetLoader) : BasePresenter<HomeContract>() {

    private var subscription: Subscription? = null

    override fun onViewReceived() {
        super.onViewReceived()
        view?.showLoader()
        subscription = assetLoader.retrieveFromAssets(object : TypeToken<ArrayList<PracticeArea>>() {}.type, "response.json")
                .subscribe({
                    view?.setData(it as ArrayList<PracticeArea>)
                }, {
                    it.printStackTrace()
                    view?.showError()
                })
    }

    override fun onDropView() {
        super.onDropView()
        if (subscription?.isUnsubscribed ?: false)
            subscription?.unsubscribe()
    }
}

