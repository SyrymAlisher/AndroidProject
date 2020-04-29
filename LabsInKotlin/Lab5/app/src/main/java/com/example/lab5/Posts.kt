package com.example.lab5

import java.util.ArrayList
import  java.io.Serializable

data class Posts(
    val logo:Int = 0,
    val author:String? = null,
    val image: Int = 0,
    val time: String? = null,
    val description: String? = null,
    val likesCnt: Int = 0,
    val comment: Int = 0,
    val repost: Int = 0,
    val views: Int = 0
    ):Serializable {
    var isLiked = false
    companion object {
        var postsArrayList: MutableList<Posts> = ArrayList()
    }

}








