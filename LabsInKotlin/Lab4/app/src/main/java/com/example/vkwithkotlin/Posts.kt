package com.example.vkwithkotlin

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi


class Posts : Parcelable {
    var logo: Int
    var author: String?
    var image: Int
    var time: String?
    var description: String?
    var like: Int
    var comment: String?
    var repost: String?
    var views: Int

    constructor(
        logo: Int, author: String?, image: Int, time: String?,
        description: String?, like: Int, comment: String?,
        repost: String?, views: Int
    ) {
        this.logo = logo
        this.author = author
        this.image = image
        this.time = time
        this.description = description
        this.like = like
        this.comment = comment
        this.repost = repost
        this.views = views
    }

    override fun describeContents(): Int {
        return 0
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(logo)
        dest.writeString(author)
        dest.writeInt(image)
        dest.writeString(time)
        dest.writeString(description)
        dest.writeInt(like)
        dest.writeString(comment)
        dest.writeString(repost)
        dest.writeInt(views)
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected constructor(`in`: Parcel) {
        logo = `in`.readInt()
        author = `in`.readString()
        image = `in`.readInt()
        time = `in`.readString()
        description = `in`.readString()
        like = `in`.readInt()
        comment = `in`.readString()
        repost = `in`.readString()
        views = `in`.readInt()
    }


    companion object CREATOR : Parcelable.Creator<Posts?> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Posts? {
            return Posts(parcel)
        }

        override fun newArray(size: Int): Array<Posts?> {
            return arrayOfNulls(size)
        }
    }
}