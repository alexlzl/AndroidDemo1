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
		MyRVAdapter3 adapter3 = new MyRVAdapter3(this, dataSet);
		rvHorizontal.setAdapter(adapter2);
		rvVertical.setAdapter(adapter);
	}

}
