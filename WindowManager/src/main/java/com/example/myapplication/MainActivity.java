package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        floatView();

        floatView2();
    }
    private FloatView floatView;
    private void floatView() {
        floatView = new FloatView(this);
        floatView.setImageResource(R.mipmap.ic_launcher);
        floatView.show();
    }
//    private FloatView2 floatView2;
    private void floatView2() {
//        floatView2 = new FloatView2(this);
//        floatView2.createFloatView(100);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        floatView2.removeFloatView();
        floatView.hide();
    }
}
