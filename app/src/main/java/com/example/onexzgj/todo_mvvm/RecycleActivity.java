package com.example.onexzgj.todo_mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.onexzgj.todo_mvvm.adapter.StudentAdapter;
import com.example.onexzgj.todo_mvvm.bean.Students;
import com.example.onexzgj.todo_mvvm.databinding.ActivityRecycleBinding;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {


    private StudentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recycle);

        ActivityRecycleBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycle);

        dataBinding.recycleView.setLayoutManager(new LinearLayoutManager(this));

        List<Students> demoList = new ArrayList<>();
        demoList.add(new Students("Zhai", "Mark", false));
        demoList.add(new Students("Zhai2", "Mark2", false));
        demoList.add(new Students("Zhai3", "Mark3", true));
        demoList.add(new Students("Zhai4", "Mark4", false));



        adapter = new StudentAdapter(RecycleActivity.this,demoList);



        dataBinding.recycleView.setAdapter(adapter);
        dataBinding.setVariable(BR.rv_presenter,new RvPresenter());

        adapter.setmListener(new StudentAdapter.OnItemClickListener() {
            @Override
            public void onClickListener(Students student) {
                Toast.makeText(RecycleActivity.this, student.getNickName(), Toast.LENGTH_SHORT).show();
            }
        });




    }

    public class RvPresenter{

        public void onClickAddItem(View view){

            adapter.addItem(new Students("男","oen x",false));
        }

        public void onClickRemoveItem(View view){

            adapter.remove();
        }
    }


}
