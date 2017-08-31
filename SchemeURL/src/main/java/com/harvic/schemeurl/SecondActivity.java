package com.harvic.schemeurl;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		Intent intent = getIntent();
        if (null != intent) {
            Uri uri = intent.getData();
            if (uri == null) {
                return;
            }
            String acionData = uri.getQueryParameter("action");

            TextView tv = (TextView)findViewById(R.id.qijian_test_tv);
            tv.append("\n��������actionֵΪ:" + acionData);
        }
	}
}
