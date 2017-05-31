package com.captech.teegarcs.mykotlinapplication.common

/**
 * Created by teegarcs on 5/24/17.
 */
abstract class BasePresenter<V> {


    protected var view:V? = null


    /**
     * Open for any class in the application to call, but the method is final.
     */
    fun takeView(view:V){
        this.view = view
        onViewReceived()
    }
    /**
     * Method is only available for classes extending and can be overrode
     */
    protected open fun onViewReceived(){
        //implement in presenters where needed.
    }


    /**
     * Open for any class in the application to call, but the method is final.
     */
    fun dropView(){
        this.view = null
        onDropView()

    }

    /**
     * Method is only available for classes extending and can be overrode
     */
    protected open fun onDropView(){
        //implement in presenters where needed
    }

}