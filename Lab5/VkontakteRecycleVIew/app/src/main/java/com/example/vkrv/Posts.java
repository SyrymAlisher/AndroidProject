package com.example.vkrv;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.util.List;

public class Posts implements Parcelable {
    public static List<Posts> postsList;

    private int logo;
    private String author;
    private int image;
    private String time;
    private String description;
    private int like;
    private String comment;
    private String repost;
    private int views;
    private  boolean isLiked;
    public Posts(int logo, String author, int image, String time,
                 String description, int like, String comment,
                 String repost,  int views) {
        this.logo = logo;
        this.author = author;
        this.image = image;
        this.time = time;
        this.description = description;
        this.like = like;
        this.comment = comment;
        this.repost = repost;
        this.views = views;
        this.isLiked = false;
    }
    public boolean isLiked() {
        return isLiked;
    }
    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public int getViews() {
        return views;
    }
    public void setViews(int views) {
        this.views = views;
    }
    public int getLogo() {
        return logo;
    }
    public void setLogo(int logo) {
        this.logo = logo;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getLike() {
        return like;
    }
    public void setLike(int like) {
        this.like = like; }
    public String getRepost() {
        return repost;
    }
    public void setRepost(String repost) {
        this.repost = repost;
    }

    @Override
    public int describeContents() {
        return 0;
    }



    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.logo);
        dest.writeString(this.author);
        dest.writeInt(this.image);
        dest.writeString(this.time);
        dest.writeString(this.description);
        dest.writeInt(this.like);
        dest.writeString(this.comment);
        dest.writeString(this.repost);
        dest.writeInt(this.views);

    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected Posts(Parcel in) {
        logo = in.readInt();
        author = in.readString();
        image = in.readInt();
        time = in.readString();
        description =  in.readString();
        like =    in.readInt();
        comment  =  in.readString();
        repost  =  in.readString();
        views = in.readInt();
    }

    public static final Parcelable.Creator<Posts> CREATOR = new Parcelable.Creator<Posts>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Posts createFromParcel(Parcel in) {
            return new Posts(in);
        }

        @Override
        public Posts[] newArray(int size) {
            return new Posts[size];
        }
    };
}
