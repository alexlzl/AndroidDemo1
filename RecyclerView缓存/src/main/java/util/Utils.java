/**   
 * @Title: Utils.java 
 * @Package com.example.recyclerviewtest.util 
 * @Description: TODO
 * @author SilentKnight || happychinapc[at]gmail[dot]com   
 * @date 2015 2015年1月22日 下午5:00:14 
 * @version V1.0.0   
 */
package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Utils
 * @Description: TODO
 * @author SilentKnight || happychinapc@gmail.com
 * @date 2015年1月22日 下午5:00:14
 * 
 */
public final class Utils {
	public static List<String> generateDataSet() {
		List<String> dataSet = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			dataSet.add("item " + i);
		}
		return dataSet;
	}
}
