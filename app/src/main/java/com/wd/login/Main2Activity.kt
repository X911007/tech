package com.wd.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        RxjavaUtil
            .instance
            .create(IApi::class.java)
            .getBannerShow(Api.URL_BANNERSHOW)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<BeanbannerShow>() {
                override fun onComplete() {
                    Log.i("Main2Activity", "??accept: ")

                }

                override fun onNext(t: BeanbannerShow) {
                    Log.i("Main2Activity", "成功accept: " + t.message)
                    Datas(t)
                }

                override fun onError(e: Throwable) {
                    Log.i("Main2Activity", "失败accept: " + e.message)

                }

            })
    }

    //加载数据
    fun Datas(t:BeanbannerShow) {
        val beanbannerShow = t as BeanbannerShow
        val result = beanbannerShow.result
        Log.i("Main2Activity", "集合accept: " + result!!.size)
//        val value =  BannerAdapter ()
        //创建适配器
//        var bann = result?.let { BannerAdapter(it, this) }
        val bann = BannerAdapter(result, this)
        //线性
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        //设置适配器
        mRecyclerView.adapter = bann
    }
}
