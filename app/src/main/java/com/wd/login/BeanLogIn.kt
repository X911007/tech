package com.wd.login

/**
 * author: Xuexiandong
 * data: 2019/12/21 10:10:46
 * function：登录
 */
class BeanLogIn {

    /**
     * result : {"headPic":"http://mobile.bwstudent.com/images/tech/default/tech.jpg","nickName":"你好哦","phone":"18946132524","pwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","sessionId":"15768964386941135","userId":1135,"userName":"EEIJ0g18946132524","whetherFaceId":0,"whetherVip":2}
     * message : 登录成功
     * status : 0000
     */

    var result: ResultBean? = null
    var message: String? = null
    var status: String? = null

    class ResultBean {
        /**
         * headPic : http://mobile.bwstudent.com/images/tech/default/tech.jpg
         * nickName : 你好哦
         * phone : 18946132524
         * pwd : R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=
         * sessionId : 15768964386941135
         * userId : 1135
         * userName : EEIJ0g18946132524
         * whetherFaceId : 0
         * whetherVip : 2
         */

        var headPic: String? = null
        var nickName: String? = null
        var phone: String? = null
        var pwd: String? = null
        var sessionId: String? = null
        var userId: Int = 0
        var userName: String? = null
        var whetherFaceId: Int = 0
        var whetherVip: Int = 0
    }
}
