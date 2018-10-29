package com.example.onexzgj.todo_mvvm.adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * databind 进行自定义属性的使用
 * Created by OnexZgj on 2018/10/26.
 */

public class DemoBindingAdapter  {

    @BindingAdapter({"app:imageUrl","app:placeholder"})
    public static void LoadImageFromUrl(ImageView imageView, String url, Drawable placeholder){
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(placeholder)
                .into(imageView);
    }


}
