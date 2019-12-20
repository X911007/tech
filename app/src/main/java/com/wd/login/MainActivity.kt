package com.wd.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var map = HashMap<String, String>()
    var edittexts: String? = null
    var nametexts: String? = null
    var pwdtexts: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*//两种赋值方式
        kte.setText("AAA")
//        kte.text="BBB"
        kte.setOnClickListener ({
            Toast.makeText(this, ""+kte.text, Toast.LENGTH_LONG).show()

        })*/

        //手机号
        var edittext = edit.text
        //昵称
        var nametext = name.text
        //密码
        var pwdtext = pwd.text
        //注册
        var registeredtext = registered.text
        //登录
        var logintext = login.text
        //登录
        login.setOnClickListener {
            edittexts = edittext.trim().toString()
            pwdtexts = pwdtext.trim().toString()

            val encryptByPublicKey = RsaCoder.encryptByPublicKey(pwdtexts)

            map.put(Api.URL_PHONE, edittexts!!)
            map.put(Api.URL_PWD, encryptByPublicKey!!)

            RxjavaUtil.instance.create(IApi::class.java)
                .postLogIn(Api.URL_LOGIN, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<BeanLogIn>() {
                    override fun onComplete() {
                        Log.i("??", "??accept: ")
                    }

                    //成功
                    override fun onNext(t: BeanLogIn) {
                        Log.i("成功", "成功accept: " + t.message)
                    }

                    //失败
                    override fun onError(e: Throwable) {
                        Log.i("失败", "失败accept: " + e.message)
                    }
                })
        }

        //注册
        registered.setOnClickListener {
            edittexts = edittext.trim().toString()
//            Toast.makeText(this, "注册" + edittexts, Toast.LENGTH_LONG).show()
            map.put(Api.URL_PHONE, "18946132524")
//            map.put(Api.URL_PHONE, trim!!)
            map.put(Api.URL_NICKNAME, "你好哦")
            map.put(Api.URL_PWD, Api.URL_PWD_S)

            RxjavaUtil.instance.create(IApi::class.java)
                .postRegistered(Api.URL_REGISTERED, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<BeanRegistered>() {
                    override fun onComplete() {
                        Log.i("??", "??accept: ")
                    }

                    //成功
                    override fun onNext(t: BeanRegistered) {
                        Log.i("成功", "成功accept: " + t.message)
                    }

                    //失败
                    override fun onError(e: Throwable) {
                        Log.i("失败", "失败accept: " + e.message)
                    }
                })
        }
    }
}
