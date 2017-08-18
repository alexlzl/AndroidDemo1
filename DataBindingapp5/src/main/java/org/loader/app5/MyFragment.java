package org.loader.app5;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyFragment extends Fragment {

    private Student mStu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        org.loader.app5.Custom binding = DataBindingUtil.inflate(inflater,
                R.layout.frag_layout, container, false);
        mStu = new Student(20, "loader");
        binding.setStu(mStu);
        binding.setFrag(this);
        return binding.getRoot();
    }

    public void click(View view) {
        mStu.setName("qibin");
        mStu.setAge(18);
    }
}
