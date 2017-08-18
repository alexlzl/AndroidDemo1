package org.loader.app7;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private org.loader.app7.Custom mBinding;
    private ObservableField<String> mString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        mString = new ObservableField<String>();
        mString.set("loader");
        mBinding.setStr(mString);
        mBinding.setHandler(this);
    }

    public void click(View view) {
        mString.set("qibin");
        mBinding.textView.setTextColor(Color.GREEN);
    }
}
