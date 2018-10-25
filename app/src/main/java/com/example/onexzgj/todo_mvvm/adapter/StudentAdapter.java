package com.example.onexzgj.todo_mvvm.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.onexzgj.todo_mvvm.BR;
import com.example.onexzgj.todo_mvvm.R;
import com.example.onexzgj.todo_mvvm.bean.Students;

import java.util.List;
import java.util.Random;

/**
 * Created by OnexZgj on 2018/10/17.
 */

public class StudentAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    public static final int ITEM_VIEW_TYPE_ON = 1;
    public static final int ITEM_VIEW_TYPE_OFF = 2;


    private List<Students> students;

    private final LayoutInflater mInflate;

    public StudentAdapter(Context context,List<Students> students) {
        mInflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.students = students;
    }


    @Override
    public int getItemViewType(int position) {
        Students student = students.get(position);
        if (student.getIsNormal()) {
            return ITEM_VIEW_TYPE_ON;
        } else {
            return ITEM_VIEW_TYPE_OFF;
        }
    }

    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ViewDataBinding binding;

        if (viewType == ITEM_VIEW_TYPE_ON) {
            binding = DataBindingUtil.inflate(mInflate, R.layout.item_normal, viewGroup, false);
        } else {
            binding = DataBindingUtil.inflate(mInflate, R.layout.item_fire_normal, viewGroup, false);
        }
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder bindingViewHolder, int position) {

        final Students student = students.get(position);
        bindingViewHolder.getBinding().setVariable(BR.students,student);

        //进行实时刷新的操作
        bindingViewHolder.getBinding().executePendingBindings();

        bindingViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener !=null){
                    mListener.onClickListener(student);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return students.size();
    }


    public void addAll(List<Students> data) {
        students.addAll(data);
    }



    Random mRandom = new Random(System.currentTimeMillis());



    public void addItem(Students student){
        int position = mRandom.nextInt(students.size() + 1);

        students.add(position,student);
        notifyItemInserted(position);

    }

    public void remove(){
        if (students.size()==0){
            return;
        }
        int position = mRandom.nextInt(students.size());
        students.remove(position);
        notifyItemRemoved(position);
    }




    private OnItemClickListener mListener;


    public interface OnItemClickListener{
        void onClickListener(Students student);
    }


    public void setmListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }



}
