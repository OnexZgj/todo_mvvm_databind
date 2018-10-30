package com.example.onexzgj.todo_mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.example.onexzgj.todo_mvvm.bean.Employee;


/**
 * 动画Activity
 */
public class AnimationActivity extends AppCompatActivity {


    private ViewDataBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_animation);

        mBinding.setVariable(BR.employee,new Employee("onex","kaiaki",true));

        mBinding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup view = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(view);
                return true;
            }
        });
        mBinding.setVariable(BR.presenter,new Presenter());
    }

    public class Presenter {
        public void onCheckedChanged(View buttonView, boolean isChecked) {
            mBinding.setVariable(BR.showImage,isChecked);
        }
    }

}
