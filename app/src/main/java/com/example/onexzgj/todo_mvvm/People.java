package com.example.onexzgj.todo_mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;

/**
 * Created by OnexZgj on 2018/10/16.
 */

public class People extends BaseObservable {

    private  String name;
    private String sex;

    public ObservableBoolean isVisable =new ObservableBoolean();


    /** 测试arraymap的使用 */
    public ObservableArrayMap<String,String> user=new ObservableArrayMap<>();


    public ObservableArrayList<String> words=new ObservableArrayList<>();


    public void setIsVisable(boolean visable) {
        isVisable.set(visable);
    }

    public People(String name, String sex) {
        this.name = name;
        this.sex = sex;
        isVisable.set(false);

        user.put("q","android");
        user.put("w","java");
        user.put("e","web");

        words.add("f");

        notifyChange();
    }

    public ObservableBoolean getIsVisable() {
        return isVisable;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.example.onexzgj.todo_mvvm.BR.name);
    }
    @Bindable
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        notifyPropertyChanged(com.example.onexzgj.todo_mvvm.BR.sex);
    }
}
