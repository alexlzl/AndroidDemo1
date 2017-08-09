package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        Bundle bundle=new Bundle();
        bundle.putString("test","bundle====");
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
