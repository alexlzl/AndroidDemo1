package org.loader.app4;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Student mStu;
    private People mPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        org.loader.app4.Custom binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        mStu = new Student("loader");
        binding.setStu(mStu);
        binding.setClick(this);
        mPeople = new People();
        binding.setPeople(mPeople);

        ObservableArrayMap<String, String> map = new ObservableArrayMap<>();
        ObservableArrayList<String> list = new ObservableArrayList<>();
        map.put("name", "loader or qibin");
        list.add("loader!!!");
        binding.setMap(map);
        binding.setList(list);
    }

    public void click(View view) {
        mStu.setName("qibin");
        mPeople.name.set("people");
        mPeople.age.set(19);
        mPeople.isMan.set(true);
    }
}
