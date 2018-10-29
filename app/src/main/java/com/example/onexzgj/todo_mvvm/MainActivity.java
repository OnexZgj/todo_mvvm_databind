package com.example.onexzgj.todo_mvvm;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.onexzgj.todo_mvvm.bean.Student;

public class MainActivity extends AppCompatActivity {


    private ViewDataBinding mBinding;
    private Student mStudent;
    private ImageView ivIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ivIcon = findViewById(R.id.iv_icon);


        Glide.with(this).load("https://avatars2.githubusercontent.com/u/1106500?v=3&s=460")
                .into(ivIcon);

        mStudent = new Student("Onex", "23");

        mBinding.setVariable(BR.Student, mStudent);
        mBinding.setVariable(BR.presenter, new Presenter());

    }

    public class Presenter {

        public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
            mStudent.setName(text.toString());
            mBinding.setVariable(BR.Student, mStudent);
        }


        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
        }

        public void onClick2(View view) {
            startActivity(new Intent(MainActivity.this, ObservableActivity.class));
        }


        public void onClickToExpression(View view){
            startActivity(new Intent(MainActivity.this,ExpressionActivity.class));

        }


        public void toListActivity(View view) {
            startActivity(new Intent(MainActivity.this, RecycleActivity.class));
        }


        public void onClickListenerBinding(Student student) {
            Toast.makeText(MainActivity.this, student.name, Toast.LENGTH_SHORT).show();
        }

    }
}
