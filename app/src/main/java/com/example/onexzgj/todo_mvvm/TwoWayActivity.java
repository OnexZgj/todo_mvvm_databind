package com.example.onexzgj.todo_mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.onexzgj.todo_mvvm.bean.FormModle;

/**
 * 双向绑定Activity
 * 进行验证双向绑定的Activity
 */
public class TwoWayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FormModle modle1=new FormModle("OneX","123456");
        ViewDataBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way);
        dataBinding.setVariable(BR.modle,modle1);
//        modle1.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
//            @Override
//            public void onPropertyChanged(Observable sender, int propertyId) {
//                Toast.makeText(TwoWayActivity.this, String.valueOf(propertyId), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
