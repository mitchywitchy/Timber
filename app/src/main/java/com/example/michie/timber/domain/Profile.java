package com.example.michie.timber.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("length")
    @Expose
    private String length;

    @SerializedName("location")
    @Expose
    private String location;

    public String getLength() {
        return length;
    }
    public String getLocation() {
        return location;
    }
    public String getUrl() {
        return url;
    }
    public String getName() {
        return name;
    }
    public void setLength(String length) {
        this.length = length;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(length);
        dest.writeString(location);
    }

    public static final Parcelable.Creator<Profile> CREATOR
            = new Parcelable.Creator<Profile>() {
        public Profile createFromParcel(Parcel in) {
            return new Profile(in);
        }

        public Profile[] newArray(int size) {
            return new Profile[size];
        }
    };

    private Profile(Parcel in) {
        name = in.readString();
        url = in.readString();
        length = in.readString();
        location = in.readString();
    }
}
