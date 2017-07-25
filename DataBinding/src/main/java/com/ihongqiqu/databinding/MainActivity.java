package com.ihongqiqu.databinding;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    private ArrayList<OnSoftKeyboardStateChangedListener> mKeyboardStateListeners;      //软键盘状态监听列表
    private ViewTreeObserver.OnGlobalLayoutListener mLayoutChangeListener;
    private boolean mIsSoftKeyboardShowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Data Binding Samples");
        editText = (EditText) findViewById(R.id.et);
        textView = (TextView) findViewById(R.id.show);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;     // 屏幕宽度（像素）
        final int height = metric.heightPixels;   // 屏幕高度（像素）
        float density = metric.density;      // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi;  // 屏幕密度DPI（120 / 160 / 240
        mIsSoftKeyboardShowing = false;

        mKeyboardStateListeners = new ArrayList<OnSoftKeyboardStateChangedListener>();
        mLayoutChangeListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //判断窗口可见区域大小
                Rect r = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
                //如果屏幕高度和Window可见区域高度差值大于整个屏幕高度的1/3，则表示软键盘显示中，否则软键盘为隐藏状态。
                int heightDifference = height - (r.bottom - r.top);
                boolean isKeyboardShowing = heightDifference > height / 3;

                //如果之前软键盘状态为显示，现在为关闭，或者之前为关闭，现在为显示，则表示软键盘的状态发生了改变
                if ((mIsSoftKeyboardShowing && !isKeyboardShowing) || (!mIsSoftKeyboardShowing && isKeyboardShowing)) {
                    mIsSoftKeyboardShowing = isKeyboardShowing;
                    for (int i = 0; i < mKeyboardStateListeners.size(); i++) {
                        OnSoftKeyboardStateChangedListener listener = mKeyboardStateListeners.get(i);
                        listener.OnSoftKeyboardStateChanged(mIsSoftKeyboardShowing, heightDifference);
                    }
                }
            }
        };
        addSoftKeyboardChangedListener(new OnSoftKeyboardStateChangedListener() {
            @Override
            public void OnSoftKeyboardStateChanged(boolean isKeyBoardShow, int keyboardHeight) {
                Toast.makeText(MainActivity.this,"是否显示软键盘"+isKeyBoardShow+"高度"+keyboardHeight,Toast.LENGTH_SHORT).show();
            }
        });
        //注册布局变化监听
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(mLayoutChangeListener);
//        openSoftKeyboard(editText);
//        ViewTreeObserver viewTreeObserver= editText.getViewTreeObserver();
//        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                editText.setFocusable(true);
//                editText.setFocusableInTouchMode(true);
//                editText.requestFocus();
//                editText.setFocusable(true);
//                editText.setFocusableInTouchMode(true);
//                editText.requestFocus();
//                InputMethodManager inputManager = (InputMethodManager)editText.getContext().getSystemService("input_method");
//                inputManager.showSoftInput(editText, 0);
//                Toast.makeText(MainActivity.this, "show", Toast.LENGTH_SHORT).show();
//            }
//        });
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                InputMethodManager imm = (InputMethodManager)MainActivity.this.getSystemService(INPUT_METHOD_SERVICE);
//                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//                Toast.makeText(MainActivity.this, "show", Toast.LENGTH_SHORT).show();
//            }
//        }, 1000);  //在一秒后打开
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        if(hasFocus){
//            openSoftKeyboard(editText);
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        openSoftKeyboard(editText);
    }

    public void openSoftKeyboard(EditText et) {
        if (et != null) {
            et.setFocusable(true);
            et.setFocusableInTouchMode(true);
            et.requestFocus();
            et.setFocusable(true);
            et.setFocusableInTouchMode(true);
            et.requestFocus();
            InputMethodManager inputManager = (InputMethodManager) et.getContext().getSystemService("input_method");
            inputManager.showSoftInput(et, 0);
//            InputMethodManager imm = (InputMethodManager)MainActivity.this.getSystemService(INPUT_METHOD_SERVICE);
//            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        }

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button2:
                startDataBindingSampleActivity1();
                break;
            case R.id.button3:
                startDataBindingSampleActivity2();
                break;
            case R.id.button4:
                startDataBindingSampleActivity3();
                break;
            case R.id.button5:
                startDataBindingSampleActivity4();
                break;
            case R.id.et_tests:
                openSoftKeyboard(editText);
                break;
        }
    }

    /**
     * 数据绑定
     */
    private void startDataBindingSampleActivity1() {
        Intent intent = new Intent(this, DataBindingSampleActivity1.class);
        startActivity(intent);
    }

    /**
     * 事件绑定
     */
    private void startDataBindingSampleActivity2() {
        Intent intent = new Intent(this, DataBindingSampleActivity2.class);
        startActivity(intent);
    }

    /**
     * 实时更新
     */
    private void startDataBindingSampleActivity3() {
        Intent intent = new Intent(this, DataBindingSampleActivity3.class);
        startActivity(intent);
    }

    private void startDataBindingSampleActivity4() {
        Intent intent = new Intent(this, DataBindingSampleActivity4.class);
        startActivity(intent);
    }


    public interface OnSoftKeyboardStateChangedListener {
        public void OnSoftKeyboardStateChanged(boolean isKeyBoardShow, int keyboardHeight);
    }

    //注册软键盘状态变化监听
    public void addSoftKeyboardChangedListener(OnSoftKeyboardStateChangedListener listener) {
        if (listener != null) {
            mKeyboardStateListeners.add(listener);
        }
    }

    //取消软键盘状态变化监听
    public void removeSoftKeyboardChangedListener(OnSoftKeyboardStateChangedListener listener) {
        if (listener != null) {
            mKeyboardStateListeners.remove(listener);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onDestroy() {
        //移除布局变化监听
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(mLayoutChangeListener);
        } else {
            getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(mLayoutChangeListener);
        }
        super.onDestroy();
    }

}
