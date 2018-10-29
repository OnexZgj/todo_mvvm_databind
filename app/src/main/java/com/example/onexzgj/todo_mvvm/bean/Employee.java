package com.example.onexzgj.todo_mvvm.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;

import com.example.onexzgj.todo_mvvm.BR;

/**
 * Created by OnexZgj on 2018/10/26.
 */

public class Employee extends BaseObservable {

    public String  mFirstName;
    public String mLastName;
    public String mAvatar;
    public ObservableBoolean isFired = new ObservableBoolean();


    public Employee(String mFirstName, String mLastName , boolean fired) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        isFired.set(fired);
    }

    @Bindable
    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
        notifyPropertyChanged(BR.mFirstName);
    }

    @Bindable
    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
        notifyPropertyChanged(BR.mLastName);
    }

    @Bindable
    public String getmAvatar() {
        return mAvatar;
    }

    public void setmAvatar(String mAvatar) {
        this.mAvatar = mAvatar;
        notifyPropertyChanged(BR.mAvatar);
    }


    public void setIsFired(boolean fired) {
        isFired.set(fired);
    }
}
