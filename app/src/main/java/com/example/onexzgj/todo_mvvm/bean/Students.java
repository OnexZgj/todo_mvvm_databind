package com.example.onexzgj.todo_mvvm.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

import com.example.onexzgj.todo_mvvm.BR;

/**
 * Created by OnexZgj on 2018/10/15.
 */

public class Students extends BaseObservable{

    private String studentSex;

    private String nickName;

    private ObservableBoolean isNormal=new ObservableBoolean();


    public Students(String studentSex, String nickName, boolean isNormal) {
        this.studentSex = studentSex;
        this.nickName = nickName;
        this.isNormal.set(isNormal);
        notifyChange();
    }

    @Bindable
    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
        notifyPropertyChanged(BR.studentSex);

    }

    @Bindable
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
        notifyPropertyChanged(BR.nickName);
    }

    public boolean getIsNormal() {
        return isNormal.get();
    }

    public void setIsNormal(boolean isNormal) {
        this.isNormal.set(isNormal);
    }
}
