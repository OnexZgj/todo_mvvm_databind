package com.example.onexzgj.todo_mvvm.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.onexzgj.todo_mvvm.BR;

/**
 * Created by OnexZgj on 2018/10/15.
 */

public class Student extends BaseObservable {

    public  String name;
    public String age;


    public Student(String name, String age) {
        this.name = name;
        this.age = age;
        notifyChange();
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);

    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);

    }
}
