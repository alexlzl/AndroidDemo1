package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import java.net.URL;

/**
 * 则source就是img的src的值，既是：http://pic004.cnblogs.com/news/201211/20121108_091749_1.jpg这个图片路径

 当然这个<img src=路径/> 这个路径既可以是网络图片，也可以本地图片，项目资源图片

 例如：本地图片<img src=\""/sdcard/images/test.jpg"\"/>   项目资源图片 <img src=\""+R.drawable.market_none_image+"\"/>

 通过这三个方式，可以看出，不同的图片路径，得到图片的处理方式不同，大家也能一目了然的看出来ImageGetter是干什么的了，就是得到img中src所需的图片！

 提醒一点：获取图片以后，一定要设置图片的边界，界线，即：drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());，不然获取图片后，Textview不能显示图片。

 通过以上三种方式，是能可以显示出来图片，但是我发现了一个问题，就是第三种，显示网络图片，我用android2.3的系统，可以显示图片出来，并且如果图片比较大，应用会卡的现象，肯定是因为使用主线程去获取网络图片造成的，但如果我用android4.0以上的系统运行，则不能显示图片，只显示小方框。

 究其原因，是在4.0的系统上执行的时候报错了，异常是：android.os.NetworkOnMainThreadException 经过查文档，原来是4.0系统不允许主线程(UI线程)访问网络，因此导致了其异常。说白了就是在主线程上访问网络，会造成主线程挂起，系统不允许使用了。

 具体处理方式看下篇：Android中Textview显示带html文本三-------【Textview显示网络图片】

 http://www.cnblogs.com/mxgsa/archive/2012/12/20/2823666.html
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView1= (TextView) findViewById(R.id.main_tv1);
         TextView textView2= (TextView) findViewById(R.id.main_tv2);
        TextView textView3= (TextView) findViewById(R.id.main_tv3);
        /**
         * final String sText2 = "测试图片信息：<img src=\"/mnt/sdcard/temp/1.jpg\" />";
         tView.setText(Html.fromHtml(sText2, imageGetter, null));

         final Html.ImageGetter imageGetter = new Html.ImageGetter() {

         public Drawable getDrawable(String source) {
         Drawable drawable=null;
         drawable=Drawable.createFromPath(source);
         　　　　    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
         return drawable;　　};
         }
         */
        /**
         * 项目资源图片=======
         */
        final Html.ImageGetter imageGetter = new Html.ImageGetter() {

            public Drawable getDrawable(String source) {
                Drawable drawable=null;
                int rId=Integer.parseInt(source);
                drawable=getResources().getDrawable(rId);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            };
        };

        final String sText1 = "测试图片信息：<img src=\""+R.drawable.apk+"\" />";
        textView1.setText(Html.fromHtml(sText1, imageGetter, null));


        /**
         * 网络 图片========
         */
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        final Html.ImageGetter imageGetter1 = new Html.ImageGetter() {

            public Drawable getDrawable(String source) {
                Drawable drawable=null;
                URL url;
                try {
                    url = new URL(source);
                    drawable = Drawable.createFromStream(url.openStream(), "");
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            };
        };
        final String sText = "测试图片信息：<br><img src=\"http://pic004.cnblogs.com/news/201211/20121108_091749_1.jpg\" />";
        textView2.setText(Html.fromHtml(sText, imageGetter1, null));



    }
}
