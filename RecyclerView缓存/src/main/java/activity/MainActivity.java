package activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.myapplication1.R;

import java.util.List;

import adapter.MyRVAdapter;
import adapter.MyRVAdapter2;
import adapter.MyRVAdapter3;
import util.Utils;

/**
 * 总之，测试的结论是这样的：在只有一种item的情况下，缓存的ViewHolder的数目为RecyclerView在滑动过程中所能在一屏内容纳的最大item个数+2。比如，在一个屏幕中只有item A可以显示，在滑动的过程最多可以出现6个item（这个最多是指所有item的个数，包括显示完全和显示不完全的总数），那么ViewHolder的缓存个数将会是8；而有至少两种item显示的情况下，每种item的ViewHolder的缓存个数为单种item在一屏内最大显示个数+1；比如，有3种item A，B，C，在滑动的过程，item A最多的情况下一屏显示了2个，那个item A对应的ViewHolder的缓存个数就是3个。
 */
public class MainActivity extends AppCompatActivity {
	private static final String TAG = MainActivity.class.getSimpleName();

	private RecyclerView rvHorizontal;
	private RecyclerView rvVertical;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rvHorizontal = (RecyclerView) findViewById(R.id.recyclier_view_horizontal);
		rvVertical = (RecyclerView) findViewById(R.id.recyclier_view_vertical);
		List<String> dataSet = Utils.generateDataSet();
		LinearLayoutManager layoutManager = new LinearLayoutManager(this,
				LinearLayout.HORIZONTAL, false);
		rvHorizontal.setLayoutManager(layoutManager);
		layoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL,
				false);
		rvVertical.setLayoutManager(layoutManager);
		MyRVAdapter adapter = new MyRVAdapter(this, dataSet);
		MyRVAdapter2 adapter2 = new MyRVAdapter2(this, dataSet);
		rvHorizontal.setAdapter(adapter2);
		rvVertical.setAdapter(adapter);
	}

}
