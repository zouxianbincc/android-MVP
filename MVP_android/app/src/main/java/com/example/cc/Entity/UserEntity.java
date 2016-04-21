package com.example.cc.Entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by cc on 16/4/13.
 */
public class UserEntity implements Parcelable {


    public String token;

    public int userId;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.token);
        dest.writeInt(this.userId);
    }

    public UserEntity() {
    }

    protected UserEntity(Parcel in) {
        this.token = in.readString();
        this.userId = in.readInt();
    }

    public static final Parcelable.Creator<UserEntity> CREATOR = new Parcelable.Creator<UserEntity>() {
        @Override
        public UserEntity createFromParcel(Parcel source) {
            return new UserEntity(source);
        }

        @Override
        public UserEntity[] newArray(int size) {
            return new UserEntity[size];
        }
    };
}
