package com.wd.login

import android.app.Activity
import android.content.Context
import android.content.Intent
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

        //手机号
        var edittext = edit.text
        //昵称
        var nametext = name.text
        //密码
        var pwdtext = pwd.text
        //登录
        login.setOnClickListener {
            edittexts = edittext.trim().toString()
            pwdtexts = pwdtext.trim().toString()

            //密码加密
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
                        if ("0000".equals(t.status)) {
                            //跳转
                            Jump()
                            //吐司
                            Toast(t.message.toString())
                        }
                    }

                    //失败
                    override fun onError(e: Throwable) {
                        Log.i("失败", "失败accept: " + e.message)
                        //吐司
                        Toast(e.message.toString())
                    }
                })
        }
        fun Login(){

        }

        //注册
        registered.setOnClickListener {
            edittexts = edittext.trim().toString()
            nametexts = nametext.trim().toString()
            pwdtexts = pwdtext.trim().toString()
            //密码加密
            val encryptByPublicKey = RsaCoder.encryptByPublicKey(pwdtexts)

            map.put(Api.URL_PHONE, edittexts!!)
            map.put(Api.URL_NICKNAME, nametexts!!)
            map.put(Api.URL_PWD, encryptByPublicKey!!)

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
                        //吐司
                        Toast(t.message.toString())
                    }

                    //失败
                    override fun onError(e: Throwable) {
                        Log.i("失败", "失败accept: " + e.message)
                        //吐司
                        Toast(e.message.toString())
                    }
                })
        }
    }

    //登录跳转
    fun Jump() {
        startActivity(Intent(this, Main2Activity::class.java))
    }

    //注册吐司
    fun Toast(t: String) {
        Toast.makeText(this, "" + t, Toast.LENGTH_LONG).show()

    }
}
