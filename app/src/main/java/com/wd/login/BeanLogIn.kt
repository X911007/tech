package com.wd.login

/**
 * author: Xuexiandong
 * data: 2019/12/20 20:20:49
 * function：登录
 */
data class BeanLogIn(
    val message: String,
    val result: Result,
    val status: String
)

data class Result(
    val headPic: String,
    val nickName: String,
    val phone: String,
    val pwd: String,
    val sessionId: String,
    val userId: Int,
    val userName: String,
    val whetherFaceId: Int,
    val whetherVip: Int
)