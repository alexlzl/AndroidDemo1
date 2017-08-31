/**   
 * @Title: MyRVAdapter2.java 
 * @Package com.example.recyclerviewtest.adapter 
 * @Description: TODO
 * @author SilentKnight || happychinapc[at]gmail[dot]com   
 * @date 2015 2015年1月22日 下午4:55:31 
 * @version V1.0.0   
 */
package adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication1.R;


/**
 * @ClassName: MyRVAdapter2
 * @Description: TODO
 * @author SilentKnight || happychinapc@gmail.com
 * @date 2015年1月22日 下午4:55:31
 * 
 */
public class MyRVAdapter2 extends RecyclerView.Adapter<MyRVAdapter2.ViewHolder> {
	private static int COUNT_CACHE_VIEW_1 = 0;
	private static int COUNT_CACHE_VIEW_2 = 0;
	private static final String ADAPTER_TAG = MyRVAdapter2.class
			.getSimpleName();
	private static final int TYPE_TV = 0x000;
	private static final int TYPE_IV = 0x0001;
	private List<String> dataSet;
	private Context context;

	public MyRVAdapter2(Context context, List<String> dataSet) {
		this.context = context;
		this.dataSet = dataSet;
	}

	/*
	 * (non-avadoc) <p>Title: getItemId</p> <p>Description: </p>
	 * 
	 * @params @param position
	 * 
	 * @params @return
	 * 
	 * @overrided @see
	 * android.support.v7.widget.RecyclerView.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/*
	 * (non-avadoc) <p>Title: getItemViewType</p> <p>Description: </p>
	 * 
	 * @params @param position
	 * 
	 * @params @return
	 * 
	 * @overrided @see
	 * android.support.v7.widget.RecyclerView.Adapter#getItemViewType(int)
	 */
	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		if (position % 2 == 0) {
			return TYPE_TV;
		} else {
			return TYPE_IV;
		}
	}

	/*
	 * (non-avadoc) <p>Title: getItemCount</p> <p>Description: </p>
	 * 
	 * @params @return
	 * 
	 * @overrided @see
	 * android.support.v7.widget.RecyclerView.Adapter#getItemCount()
	 */
	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return dataSet.size();
	}

	/*
	 * (non-avadoc) <p>Title: onBindViewHolder</p> <p>Description: </p>
	 * 
	 * @params @param arg0
	 * 
	 * @params @param arg1
	 * 
	 * @overrided @see
	 * android.support.v7.widget.RecyclerView.Adapter#onBindViewHolder
	 * (android.support.v7.widget.RecyclerView.ViewHolder, int)
	 */
	@Override
	public void onBindViewHolder(ViewHolder holder, int arg1) {
		// TODO Auto-generated method stub
		if (getItemViewType(arg1) == TYPE_TV) {
			holder.tv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					context.startActivity(new Intent(context,
//							GridViewHorizontalTest.class));
				}
			});
			holder.tv.setText(dataSet.get(arg1));
		} else {
			holder.iv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
//					context.startActivity(new Intent(context,
//							GridViewVerticalTest.class));
				}
			});
		}
	}

	/*
	 * (non-avadoc) <p>Title: onCreateViewHolder</p> <p>Description: </p>
	 * 
	 * @params @param arg0
	 * 
	 * @params @param arg1
	 * 
	 * @params @return
	 * 
	 * @overrided @see
	 * android.support.v7.widget.RecyclerView.Adapter#onCreateViewHolder
	 * (android.view.ViewGroup, int)
	 */

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int arg1) {
		// TODO Auto-generated method stub
		if (getItemViewType(arg1) == TYPE_TV) {
			Log.i(ADAPTER_TAG, "itemTV---" + ++COUNT_CACHE_VIEW_1);
			View itemLayout = LayoutInflater.from(viewGroup.getContext())
					.inflate(R.layout.recycler_view_item_layout_tv, null);
			return new ViewHolder(itemLayout, TYPE_TV);
		} else {
			Log.i(ADAPTER_TAG, "itemIV---" + ++COUNT_CACHE_VIEW_2);
			View itemLayout = LayoutInflater.from(viewGroup.getContext())
					.inflate(R.layout.recycler_view_item_layout_iv, null);
			return new ViewHolder(itemLayout, TYPE_IV);
		}
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TextView tv;
		public ImageView iv;

		/**
		 * <p>
		 * Title: MainActivity.java
		 * </p>
		 * <p>
		 * Description:
		 * </p>
		 * 
		 * @param @param itemView
		 */
		public ViewHolder(View itemView, int itemType) {
			super(itemView);
			// TODO Auto-generated constructor stub
			if (itemType == TYPE_TV) {
				tv = (TextView) itemView.findViewById(R.id.rv_item_tv);
			} else {
				iv = (ImageView) itemView.findViewById(R.id.rv_item_iv);
			}
		}
	}
}