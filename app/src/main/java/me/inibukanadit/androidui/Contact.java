package me.inibukanadit.androidui;

/**
 * Created by inibukanadit on 12/14/17.
 */

public class Contact {

    private int mAvatar;
    private String mName;
    private String mMessage;
    private String mTime;

    public Contact() {
    }

    public Contact(int avatar, String name, String message, String time) {
        mAvatar = avatar;
        mName = name;
        mMessage = message;
        mTime = time;
    }

    public int getAvatar() {
        return mAvatar;
    }

    public void setAvatar(int avatar) {
        mAvatar = avatar;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        this.mTime = time;
    }
}
