package com.captech.teegarcs.mykotlinapplication.common

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by tgarden on 5/26/17.
 */
class MyKotlinApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}