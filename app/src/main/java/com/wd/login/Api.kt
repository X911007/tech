package com.wd.login

/**
 * author: Xuexiandong
 * data: 2019/11/2 09:9:36
 * function：常量类
 */
interface Api {
    companion object {
        /**
         * Base内
         */
        val BASE_URL = "https://172.17.8.100/"
        /**
         * Base外
         */
        val BASE_URL_ = "https://mobile.bwstudent.com/"
        //-----------------------------------------------------------------------------X
        /**
         * 注册
         */
        val URL_REGISTERED = "techApi/user/v1/register"
        /**
         * 登录
         */
        val URL_LOGIN = "techApi/user/v1/login"
        /**
         * banner轮播
         */
        val URL_BANNERSHOW = "techApi/information/v1/bannerShow"
        /**
         * /手机号
         */
        val URL_PHONE = "phone"
        //昵称
        val URL_NICKNAME = "nickName"
        //密码
        val URL_PWD = "pwd"
        //域名
        val URL_MOBILE = "mobile.bwstudent.com"
        //密码s
        val URL_PWD_S =
            "H2MOJwtVFNvpvt261DXHGnXv+hR455BRCFAD7VagO61kUFB6YS+6D6TXTEJsmFbQ8APkJsqyHlOwSNn3yW3Pme4rz5INN/3xbFMkZ0FVP0yYOX73MPH36zCW0x4T+5gnvmKXXL9F08Ua0TiEZUQ0Q/Z3xCsD/LPVAI/pPWtIxQc="
    }


}


