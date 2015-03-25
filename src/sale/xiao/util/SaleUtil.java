package sale.xiao.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	
	public static HttpSession getSession(HttpServletRequest request){
	    
	    // fasle 表示检测当前时候有session存在，如果不存在则创建一个，如果存在就返回当前的。
	    // true 不管当前是否存在Session都创建一个
	    HttpSession session = request.getSession(false);
	    
	    return session;
	}
}
