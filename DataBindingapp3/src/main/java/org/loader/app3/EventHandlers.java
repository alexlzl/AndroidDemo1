package org.loader.app3;

import android.view.View;
import android.widget.Toast;

/**
 * Created by qibin on 2015/8/7.
 */
public class EventHandlers {
    public void handleClick(View view) {
        Toast.makeText(view.getContext(), "you clicked the view", Toast.LENGTH_LONG).show();
    }
}
