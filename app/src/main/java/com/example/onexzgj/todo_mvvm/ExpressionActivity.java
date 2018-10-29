package com.example.onexzgj.todo_mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.onexzgj.todo_mvvm.bean.Employee;

import java.util.Random;

public class ExpressionActivity extends AppCompatActivity {



    Random mRandom=new Random(System.currentTimeMillis());
    private ViewDataBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Employee employee =new Employee("凯","OnexZgj",true);
        employee.setmAvatar("https://avatars2.githubusercontent.com/u/1106500?v=3&s=460");

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_expression);

        dataBinding.setVariable(com.example.onexzgj.todo_mvvm.BR.employee,employee);



    }
}
