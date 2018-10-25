package com.example.onexzgj.todo_mvvm.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by OnexZgj on 2018/10/17.
 */

public class BindingViewHolder <T extends ViewDataBinding > extends RecyclerView.ViewHolder{

    private T mBinding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        mBinding=binding;
    }

    public T getBinding(){
        return mBinding;
    }

}
