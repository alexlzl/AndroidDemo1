package com.ihongqiqu.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.ihongqiqu.databinding.databinding.ActivityDataBindingRvBinding;

public class DataBindingRV extends AppCompatActivity {
    RvViewModel rvViewModel;
    BindingAdapter bindingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingRvBinding bindingRvBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_rv);
        rvViewModel = new RvViewModel();
        rvViewModel.setName("lzl");
        bindingRvBinding.setRvData(rvViewModel);
        bindingAdapter = new BindingAdapter(this);
        bindingRvBinding.rv.setLayoutManager(new LinearLayoutManager(this));
        bindingRvBinding.rv.setAdapter(bindingAdapter);
    }

    public void add(View view){
        Toast.makeText(this,"test",Toast.LENGTH_LONG).show();
                RvViewModel.Item item=new RvViewModel.Item();
        item.setAge("1000");
        item.setTitle("测试");
        bindingAdapter.addData(0,item);
        bindingAdapter.notifyDataSetChanged();
    }

    public void add1(View view){
        Toast.makeText(this,"test",Toast.LENGTH_LONG).show();
        bindingAdapter.add1();
    }
}
