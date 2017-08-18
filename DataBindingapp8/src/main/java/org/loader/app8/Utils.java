package org.loader.app8;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * Created by qibin on 2015/8/12.
 */
public class Utils {
    @BindingAdapter({"bind:image"})
    public static void imageLoader(ImageView imageView, String url) {
        ImageLoaderUtils.getInstance().displayImage(url, imageView);
    }
}
