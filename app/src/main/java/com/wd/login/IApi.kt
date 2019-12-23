package com.wd.login

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * author: Xuexiandong
 * data: 2019/12/20 14:14:58
 * function：
 */
interface IApi {
    //轮播
    @GET
    fun getBannerShow(@Url url: String): Observable<BeanbannerShow>

    //注册
    @FormUrlEncoded
    @POST
    fun postRegistered(@Url url: String, @FieldMap map: HashMap<String, String>): Observable<BeanRegistered>

    //登录
    @FormUrlEncoded
    @POST
    fun postLogIn(@Url url: String, @FieldMap map: HashMap<String, String>): Observable<BeanLogIn>

}