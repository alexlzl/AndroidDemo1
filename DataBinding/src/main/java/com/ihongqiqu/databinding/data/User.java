package com.ihongqiqu.databinding.data;

import android.databinding.BaseObservable;

/**
 * 用户实体
 * <p/>
 * Created by zhenguo on 3/13/16.
 */
public class User extends BaseObservable {

//    public final String name;
//    public final String age;
     public  String name;
    public  String age;
    public User(String name, String age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyChange();
    }
}
