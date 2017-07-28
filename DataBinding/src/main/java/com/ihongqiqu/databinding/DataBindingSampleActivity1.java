package com.ihongqiqu.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ihongqiqu.databinding.data.User;
import com.ihongqiqu.databinding.BR;
import com.ihongqiqu.databinding.databinding.ActivityDataBindingSample1Binding;
import com.ihongqiqu.databinding.event.MyHandlers;

/**
 * 数据绑定==
 */
public class DataBindingSampleActivity1 extends AppCompatActivity {
    User user;//在onCreate onStart onResume 中均可以给user赋值，数据可以正常绑定
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("数据绑定");

//         user = new User("jingle1267", "20");
        user = new User("", "");
//        user.setAge("999");
//        user.setName("lzl==lzl");

        // 第一种初始化方式
        ActivityDataBindingSample1Binding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_data_binding_sample1);
        binding.setUser(user);
//        user.setAge("99");
//        user.setName("lzl");

        // 第二种初始化方式
//        ViewDataBinding binding1 = DataBindingUtil.setContentView(this,
//                R.layout.activity_data_binding_sample1);
//        binding1.setVariable(BR.user, user);

    }

    @Override
    protected void onStart() {
        super.onStart();
//        user.setAge("99");
//        user.setName("lzl");
    }

    @Override
    protected void onResume() {
        super.onResume();
        user.setAge("99");
        user.setName("lzl");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        user.setAge("99");
//        user.setName("lzl");
    }

    public void update(View view){
        Toast.makeText(this,"test",Toast.LENGTH_LONG).show();
        user.setAge("1000");
        user.setName("lzl=");
    }

}
