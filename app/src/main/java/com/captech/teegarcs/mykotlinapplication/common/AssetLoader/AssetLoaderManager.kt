package com.captech.teegarcs.mykotlinapplication.common.AssetLoader

import android.content.Context
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Type

/**
 * Created by teegarcs on 5/25/17.
 */
class AssetLoaderManager(val context: Context) : AssetLoader {

    val gson: Gson = GsonBuilder().disableHtmlEscaping().create()

    /**
     * Method to return an observable to steam any type of data.
     */
    override fun retrieveFromAssets(typeOfT: Type, fileName: String): Observable<Any> {
        return Observable.create(Observable.OnSubscribe<Any> { subscriber ->
            var rawObjectData = openAsset(fileName)
            if (TextUtils.isEmpty(rawObjectData)) {
                subscriber.onError(Exception(fileName))
            }
            //must use type token as passing in the java class reference failed with a mapping error
            subscriber.onNext(gson.fromJson(rawObjectData, typeOfT))
            subscriber.onCompleted()
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * Method to return a String of data from an Assets folder. For our use case it will be JSON
     */
    private fun openAsset(fileName: String): String {
        val assetManager = context.assets

        val stringBuilder = StringBuilder()

        val inputReader = InputStreamReader(assetManager?.open(fileName))

        val bufferReader = BufferedReader(inputReader)

        var receivedString = bufferReader.readLine()

        while (receivedString != null) {
            stringBuilder.append(receivedString)
            receivedString = bufferReader.readLine()
        }

        inputReader.close()
        bufferReader.close()

        return stringBuilder.toString()
    }
}