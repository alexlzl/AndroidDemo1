package org.loader.app5;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Student extends BaseObservable {
    private String name;
    private int age;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(org.loader.app5.BR.age);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(org.loader.app5.BR.name);
    }
}
