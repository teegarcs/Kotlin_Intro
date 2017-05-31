package com.captech.teegarcs.mykotlinapplication.common.AssetLoader

import rx.Observable
import java.lang.reflect.Type


/**
 * Created by teegarcs on 5/25/17.
 */
interface AssetLoader {

    fun retrieveFromAssets(typeOfT: Type, fileName: String): Observable<Any>
}