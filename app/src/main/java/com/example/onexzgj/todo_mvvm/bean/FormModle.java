package com.example.onexzgj.todo_mvvm.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.onexzgj.todo_mvvm.BR;

/**
 * Created by OnexZgj on 2018/10/29.
 */

public class FormModle extends BaseObservable {

    public String mName;
    public String mPassWord;

    public FormModle(String name, String password) {
        this.mName = name;
        this.mPassWord = password;
    }


    @Bindable
    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        this.mName = name;
        notifyPropertyChanged(BR.mName);
    }

    @Bindable
    public String getmPassWord() {
        return mPassWord;
    }

    public void setmPassWord(String passWord) {
        this.mPassWord = passWord;
        notifyPropertyChanged(BR.mPassWord);
    }
}
