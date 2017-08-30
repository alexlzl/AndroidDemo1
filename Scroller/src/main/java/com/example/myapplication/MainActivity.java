package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Scroller;
import android.widget.Toast;

import com.example.scroller.R;

public class MainActivity extends AppCompatActivity {
    Scroller scroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scroller=new Scroller(this);
    }

    public void  test(View view){
        Toast.makeText(this,"test",Toast.LENGTH_LONG).show();
//      float w=  getResources().getDisplayMetrics().widthPixels;
//        float h=getResources().getDisplayMetrics().heightPixels;
//        scroller.startScroll(0,0,100,100,2000);
//        view.setTranslationX(100);
//        view.setTranslationY(100);
//        while (scroller.computeScrollOffset()){
//            Log.e("tag","getCurrX=="+scroller.getCurrX()+"getCurrY"+scroller.getCurrY());
////            view.setX(scroller.getCurrX());
////            view.setY(scroller.getCurrY());
////            view.offsetLeftAndRight(scroller.getCurrX());
////            view.offsetLeftAndRight(scroller.getCurrY());
////            view.scrollTo(scroller.getCurrX(),scroller.getCurrY());
//              view.setTranslationX(scroller.getCurrX());
//            view.setTranslationY(scroller.getCurrY());
//        }
    }
}
