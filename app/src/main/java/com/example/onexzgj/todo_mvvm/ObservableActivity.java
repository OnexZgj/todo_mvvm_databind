package com.example.onexzgj.todo_mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.onexzgj.todo_mvvm.databinding.ActivityObservableBinding;

public class ObservableActivity extends AppCompatActivity {

    private People mpeople;
    private ActivityObservableBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_observable);

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_observable);

        mpeople = new People("zgj","男");

        dataBinding.setPeople(mpeople);

        final ImageView iv = findViewById(R.id.iv);


        Button btnAoChange = findViewById(R.id.btn_ao_change);


        btnAoChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //改变相关属性值，自动更新UI中的数据
                mpeople.setName("zhanggengjie");
                mpeople.setIsVisable(!mpeople.isVisable.get());
                if (mpeople.isVisable.get()){
                    iv.setVisibility(View.VISIBLE);
                }
                else{
                    iv.setVisibility(View.GONE);
                }
            }
        });

        Button btnAoChangeMap = findViewById(R.id.btn_ao_change_map);
        btnAoChangeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ObservableArrayMap 中的数据变化，直接会在xml中反馈
                mpeople.user.put("q","onex");


                //ObservableArrayList 中的数据变化，直接回在xml中进行反馈
                mpeople.words.add("添加的数据");



            }
        });

    }
}
