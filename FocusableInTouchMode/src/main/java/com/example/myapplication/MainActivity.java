package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 *   大多数控件都可以获取焦点，也就是处在选中状态。如果Android：focusable属性值为true，表示可以通过键盘（虚拟键盘或物理键盘）或轨迹球将焦点移动到当前控件上。如果设置该属性为false，则无法将焦点移到当前控件。
 在默认情况下，触摸一个按钮虽然可以触发控件的单击事件，但无法使控件处在焦点状态。而将android：focusableInTouchMode属性设置为true，当触摸值设为ture，当触摸某个控件时，会先将焦点移动到被触摸的控件上，然后需要再触摸该控件才会响应单击事件。但要注意，需要将android：focusable属性设置为true，当前控件菜可以获得焦点，否则当前控件无论使用任何方式都无法获取焦点。
 -----------------------------------------------------
 focusable表示 移动光标时 是否能聚焦到组件上，比如按钮，就是移动光标是按钮会变成选中状态，如果focusable为false，那么就跳过此 组件，下一个组件变成选中状态。
 focusableInTouchMode可以通过触摸获取焦点。
 -------------------------------------------------
 在项目中，一进入一个页面, EditText默认就会自动获取焦点。
 那么如何取消这个默认行为呢？
 在网上找了好久，有点 监听软键盘事件，有点 调用 clearFouse()方法，但是测试了都没有！ xml中也找不到相应的属性可以关闭这个默认行为
 解决之道：在EditText的父级控件中找一个，设置成
 Android:focusable="true"
 android:focusableInTouchMode="true"
 这样，就把EditText默认的行为截断了！
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);

    }
}
