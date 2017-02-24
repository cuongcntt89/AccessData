package com.application.accessdata.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by CuongNV on 2/23/2017.
 */

public class DataDummy implements Parcelable {
    public int mId;
    public String mTitle = "";
    public String mDescription = "";

    public DataDummy(int id, String title, String description) {
        this.mId = id;
        this.mTitle = title;
        this.mDescription = description;
    }

    public DataDummy(Parcel in) {
        this.mId = in.readInt();
        this.mTitle = in.readString();
        this.mDescription = in.readString();
    }

    public static final Parcelable.Creator<DataDummy> CREATOR = new Parcelable.Creator<DataDummy>() {
        public DataDummy createFromParcel(Parcel in) {
            return new DataDummy(in);
        }

        public DataDummy[] newArray(int size) {
            return new DataDummy[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeString(this.mTitle);
        dest.writeString(this.mDescription);
    }
}