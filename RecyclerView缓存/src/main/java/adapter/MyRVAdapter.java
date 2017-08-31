/**   
 * @Title: MyRVAdapter.java 
 * @Package com.example.recyclerviewtest.adapter 
 * @Description: TODO
 * @author SilentKnight || happychinapc[at]gmail[dot]com   
 * @date 2015 2015年1月22日 下午4:54:25 
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication1.R;


/**
 * @ClassName: MyRVAdapter
 * @Description: TODO
 * @author SilentKnight || happychinapc@gmail.com
 * @date 2015年1月22日 下午4:54:25
 * 
 */
public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.ViewHolder> {
	private static int COUNT_CACHE_VIEW = 0;
	private static final String ADAPTER_TAG = MyRVAdapter.class.getSimpleName();
	private List<String> dataSet;
	private Context context;

	public MyRVAdapter(Context context, List<String> dataSet) {
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
	public void onBindViewHolder(ViewHolder holder, final int arg1) {
		// TODO Auto-generated method stub
		holder.tv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "You clickd TextView at index of "+arg1,
						Toast.LENGTH_SHORT).show();
			}
		});
		holder.tv.setText(dataSet.get(arg1));
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
		Log.i(ADAPTER_TAG, "itemTV---" + ++COUNT_CACHE_VIEW);
		View itemLayout = LayoutInflater.from(viewGroup.getContext()).inflate(
				R.layout.recycler_view_item_layout_tv, null);
		return new ViewHolder(itemLayout);
	}

	public static class ViewHolder extends RecyclerView.ViewHolder {
		public TextView tv;

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
		public ViewHolder(View itemView) {
			super(itemView);
			// TODO Auto-generated constructor stub
			tv = (TextView) itemView.findViewById(R.id.rv_item_tv);
		}
	}
}