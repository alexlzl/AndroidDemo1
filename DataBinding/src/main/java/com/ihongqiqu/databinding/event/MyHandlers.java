package com.ihongqiqu.databinding.event;

import android.view.View;
import android.widget.Toast;

import com.ihongqiqu.databinding.data.OnClickCommand;

/**
 * 时间处理
 * <p/>
 * Created by zhenguo on 3/13/16.
 */
public class MyHandlers {

    public final void onClickName(View view) {
        Toast.makeText(view.getContext(), "onClickName()", Toast.LENGTH_SHORT).show();
    }

    public final void  onClickAge( View view) {
        Toast.makeText(view.getContext(), "onClickAge()", Toast.LENGTH_SHORT).show();
//       TestI testI=new TestI() {
//           @Override
//           public void test(int viewid) {
////               Toast.makeText(view.getContext(), "onClickAge()", Toast.LENGTH_SHORT).show();
//           }
//       };
//       return  testI;
//        return 0;
    }
    public OnClickCommand OnHeaderCommand() {
        return new OnClickCommand() {
            @Override
            public void execute(int viewId) {
            }
        };
    }

    public interface TestI{
        void test(int viewid);
    }
}
