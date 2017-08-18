package org.loader.app9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        org.loader.app9.Custom binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        binding.setTime(new Date());
    }
}
