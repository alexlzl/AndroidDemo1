package activity; /**
 * @Title: GridViewHorizontalTest.java 
 * @Package com.example.recyclerviewtest 
 * @Description: TODO
 * @author SilentKnight || happychinapc[at]gmail[dot]com   
 * @date 2015 2015年1月22日 下午3:49:08 
 * @version V1.0.0   
 */


import android.os.Bundle;
import android.support.v17.leanback.widget.HorizontalGridView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.myapplication1.R;

import adapter.MyRVAdapter;
import util.Utils;

/**
 * @ClassName: GridViewHorizontalTest
 * @Description: TODO
 * @author SilentKnight || happychinapc@gmail.com
 * @date 2015年1月22日 下午3:49:08
 * 
 */
public class GridViewHorizontalTest extends AppCompatActivity {
	private HorizontalGridView gvHorizontal;

	/*
	 * (non-avadoc) <p>Title: onCreate</p> <p>Description: </p>
	 * 
	 * @params @param savedInstanceState
	 * 
	 * @overrided @see
	 * android.support.v7.app.ActionBarActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_view_horizontal_layout);
		gvHorizontal = (HorizontalGridView) findViewById(R.id.v17_horizontal_gridview);
		gvHorizontal.setLayoutManager(new LinearLayoutManager(this));
		gvHorizontal.setAdapter(new MyRVAdapter(this, Utils.generateDataSet()));
	}
}
