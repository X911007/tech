package com.wd.login

/**
 * author: Xuexiandong
 * data: 2019/12/21 10:10:48
 * function：轮播
 */
class BeanbannerShow {

    /**
     * result : [{"imageUrl":"http://mobile.bwstudent.com/images/tech/banner/191030095025561.png","jumpUrl":"wd://information?infoId=64","rank":1,"title":"区块链\u201c地位\u201d提升，百度智能云助力国家加快推动区块链产业自主创新"},{"imageUrl":"http://mobile.bwstudent.com/images/tech/banner/191106170557911.png","jumpUrl":"http://www.itbear.com.cn/html/2019-11/362293.html","rank":2,"title":"1亿像素能装下多少字？小米CC9 Pro挑战拍《新华字典》"},{"imageUrl":"http://mobile.bwstudent.com/images/tech/banner/191106165919191.jpg","jumpUrl":"http://www.itbear.com.cn/html/2019-11/362292.html","rank":3,"title":"科大讯飞翻译机强势赋能进博会 AI国货让世界\u201c聊得来\u201d"},{"imageUrl":"http://mobile.bwstudent.com/images/tech/banner/191106165563551.jpg","jumpUrl":"http://www.itbear.com.cn/html/2019-11/362290.html","rank":4,"title":"揭秘5G商用套路：看看北京的5G网络到底如何？"},{"imageUrl":"http://mobile.bwstudent.com/images/tech/banner/191106154094941.png","jumpUrl":"http://www.itbear.com.cn/html/2019-11/362266.html","rank":5,"title":"中国市场这么大，送餐机器人助力4万亿餐饮业转型"},{"imageUrl":"http://mobile.bwstudent.com/images/tech/banner/20181026151647.png","jumpUrl":"http://mobile.bwstudent.com/htm/lottery/index.html","rank":5,"title":"抽奖"}]
     * message : 查询成功
     * status : 0000
     */

    var message: String? = null
    var status: String? = null
    var result: List<ResultBean>? = null

    class ResultBean {
        /**
         * imageUrl : http://mobile.bwstudent.com/images/tech/banner/191030095025561.png
         * jumpUrl : wd://information?infoId=64
         * rank : 1
         * title : 区块链“地位”提升，百度智能云助力国家加快推动区块链产业自主创新
         */

        var imageUrl: String? = null
        var jumpUrl: String? = null
        var rank: Int = 0
        var title: String? = null
    }
}
