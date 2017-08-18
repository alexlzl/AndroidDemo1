package org.loader.app2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.loader.app2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        binding.setStu(new Student("loader"));
        binding.setStr("string");
        binding.setError(false);

        ArrayList<String> list = new ArrayList<String>() {
            {
                add("arraylist");
            }
        };
        binding.setList(list);
        binding.setListKey(0);

        HashMap<String, String> map = new HashMap<String, String>() {
            {
                put("name", "hashmap");
            }
        };
        binding.setMap(map);
//        binding.setMapKey("name");

        String[] array = new String[1];
        array[0] = "array";
        binding.setArray(array);
        binding.setArrayKey(0);
    }
}
