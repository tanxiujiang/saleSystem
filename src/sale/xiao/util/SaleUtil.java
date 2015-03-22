package sale.xiao.util;

import com.google.gson.Gson;

/**
 * 
 * @author Administrator
 *
 */
public class SaleUtil {

	final static Gson gson = new Gson();
	
	/**
	 * @description 幻化成gson字符串
	 * @param o
	 * @return
	 */
	public static String GetGsonStr(final Object o){
		return gson.toJson(o);
	}
	
}
