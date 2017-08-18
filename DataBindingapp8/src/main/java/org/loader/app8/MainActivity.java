package org.loader.app8;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        org.loader.app8.Custom binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        binding.setImageUrl("http://images.csdn.net/20150810/Blog-Image%E5%89%AF%E6%9C%AC.jpg");
    }
}
