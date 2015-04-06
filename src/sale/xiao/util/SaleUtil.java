package sale.xiao.util;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	
	/**
	 * 
	* <method description>
	* httpSession的获取
	* @param request
	* @return
	 */
	public static HttpSession getSession(HttpServletRequest request){
	    
	    // fasle 表示检测当前时候有session存在，如果不存在则创建一个，如果存在就返回当前的。
	    // true 不管当前是否存在Session都创建一个
	    HttpSession session = request.getSession();
	    
	    return session;
	}
	
	
	/**
	 * 
	* <method description>
	*  获取当前系统时间字符串
	* @return
	 */
	public static String GetCurrentDate(){
	    Date date = new Date();
	    SimpleDateFormat fomt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    return fomt.format(date);
	}
	
	/**
	 * 
	* <method description>
	* 生成产品唯一的订单编码
	* @return
	 */
	public static String GetProductId(){
	    
	    // 日期字符串
	    Date date = new Date();
	    SimpleDateFormat fomt = new SimpleDateFormat("yyyyMMddhhmmssSSSS");
	    
	    // 2位随机数10-99
	    int muber = (int)(Math.random()*90+10);
	    StringBuffer idStr = new StringBuffer(fomt.format(date)).append(muber);
	    return idStr.toString();
	}
}
