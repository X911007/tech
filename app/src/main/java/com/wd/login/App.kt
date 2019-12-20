package com.wd.login

import android.app.Application
import android.content.Context

class App : Application(){

    companion object{
        lateinit var mcontent: Context
        fun getContent() :Context{
            return  mcontent
        }
    }
    override fun onCreate() {
        super.onCreate()
        mcontent =this
    }
}
