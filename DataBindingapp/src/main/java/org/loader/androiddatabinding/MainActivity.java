package org.loader.androiddatabinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        org.loader.androiddatabinding.Custom binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setStu(new Student("loader", "山东莱芜"));
    }
}
