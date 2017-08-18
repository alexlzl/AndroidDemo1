package org.loader.app8;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;

public class ImageLoaderUtils {
	private static ImageLoaderUtils sInstance;
	
	private DisplayImageOptions mOptions;
	
	public synchronized static ImageLoaderUtils getInstance() {
		if(sInstance == null) sInstance = new ImageLoaderUtils();
		return sInstance;
	}
	
	private ImageLoaderUtils() {
		setDefault();
	}
	
	private void setDefault() {
		mOptions = new DisplayImageOptions.Builder()
		.cacheInMemory(true)
		.cacheOnDisk(true)
		.considerExifParams(true)
		.displayer(new SimpleBitmapDisplayer()).build();
	}
	
	/**
	 * 设置默认的图标
	 * @param res
	 * @return
	 */
	public ImageLoaderUtils defaultIcon(int res) {
		mOptions = new DisplayImageOptions.Builder()
		.showImageOnLoading(res)
		.showImageForEmptyUri(res)
		.showImageOnFail(res)
		.cacheInMemory(true)
		.cacheOnDisk(true)
		.considerExifParams(true)
		.displayer(new SimpleBitmapDisplayer()).build();
		
		return sInstance;
	}

	public void displayImage(String uri, ImageView imageView) {
		displayImage(uri, imageView, mOptions);
//		ImageLoader.getInstance().displayImage(uri, imageView, mOptions);
		setDefault(); // 恢复默认
	}

	private void displayImage(String uri, ImageView imageView, DisplayImageOptions options) {
		if(uri == null) return;
		ImageLoader.getInstance().displayImage(uri, imageView, options);
	}
}
