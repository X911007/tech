package com.wd.login

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * author: Xuexiandong
 * data: 2019/12/20 10:10:48
 * function：
 */
//private constructor() 私有构造
class RxjavaUtil private constructor() {

    private var readable: Retrofit? = null

    //companion object  单例
    companion object {
        val instance: RxjavaUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RxjavaUtil()
        }
    }

    //init  构造方法
    init {
        var okhttp = HttpLoggingInterceptor()
        okhttp.level = HttpLoggingInterceptor.Level.BODY

        var ok: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(okhttp)
            .build()

        readable = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Api.BASE_URL_)
            .client(ok)
            .build()
    }

    fun <T> create(tClass: Class<T>): T {
        return readable!!.create(tClass)
    }

    //接口回调
    open interface onCallBack {
        fun onSuccess(success: String)
        fun onFail(fail: String)
    }

    /*//Get请求
    fun doGet(url: String, callBack: onCallBack) {
        create!!.get(url)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }*/


}