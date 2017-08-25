package com.example.databinding_bindingconversion;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        BindConversion bindConversion= DataBindingUtil.setContentView(this,R.layout.activity_main);
        bindConversion.setIsColor(true);
    }
}
