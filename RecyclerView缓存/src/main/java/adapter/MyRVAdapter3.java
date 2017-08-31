/**   
 * @Title: MyRVAdapter3.java 
 * @Package com.example.recyclerviewtest.adapter 
 * @Description: TODO
 * @author SilentKnight || happychinapc[at]gmail[dot]com   
 * @date 2015 2015年1月22日 下午4:56:33 
 * @version V1.0.0   
 */
package adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication1.R;


/**
 * @ClassName: MyRVAdapter3
 * @Description: TODO
 * @author SilentKnight || happychinapc@gmail.com
 * @date 2015年1月22日 下午4:56:33
 * 
 */
public class MyRVAdapter3 extends RecyclerView.Adapter<MyRVAdapter3.ViewHolder> {
	private static int COUNT_CACHE_VIEW_1 = 0;
	private static int COUNT_CACHE_VIEW_2 = 0;
	private static int COUNT_CACHE_VIEW_3 = 0;
	private static final String ADAPTER_TAG = MyRVAdapter3.class
			.getSimpleName();
	private static final int TYPE_TV = 0x000;
	private static final int TYPE_IV = 0x0001;
	private static final int TYPE_TV_2 = 0x0002;
	private List<String> dataSet;
	private Context context;

	public MyRVAdapter3(Context context, List<String> dataSet) {
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
		if (position % 3 == 0) {
			return TYPE_TV;
		} else if (position % 3 == 1) {
			return TYPE_IV;
		} else {
			return TYPE_TV_2;
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
					Toast.makeText(context, "You clickd TextView",
							Toast.LENGTH_SHORT).show();
				}
			});
			holder.tv.setText(dataSet.get(arg1));
		} else if (getItemViewType(arg1) == TYPE_IV) {
			holder.iv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					Toast.makeText(context, "You clickd ImageView",
							Toast.LENGTH_SHORT).show();
				}
			});
		} else {

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
		} else if (getItemViewType(arg1) == TYPE_IV) {
			Log.i(ADAPTER_TAG, "itemIV---" + ++COUNT_CACHE_VIEW_2);
			View itemLayout = LayoutInflater.from(viewGroup.getContext())
					.inflate(R.layout.recycler_view_item_layout_iv, null);
			return new ViewHolder(itemLayout, TYPE_IV);
		} else {
			Log.i(ADAPTER_TAG, "itemTV2---" + ++COUNT_CACHE_VIEW_3);
			View itemLayout = LayoutInflater.from(viewGroup.getContext())
					.inflate(R.layout.recycler_view_item_layout_tv_2, null);
			return new ViewHolder(itemLayout, TYPE_TV_2);
		}
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TextView tv;
		public TextView tv2;
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
			} else if (itemType == TYPE_IV) {
				iv = (ImageView) itemView.findViewById(R.id.rv_item_iv);
			} else {
				tv2 = (TextView) itemView.findViewById(R.id.rv_item_tv);
			}
		}
	}
}