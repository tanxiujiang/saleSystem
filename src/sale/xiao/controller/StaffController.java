package sale.xiao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

import sale.xiao.entity.ProductEntity;
import sale.xiao.entity.StaffEntity;
import sale.xiao.service.StaffService;
import sale.xiao.util.SaleUtil;

/**
 * @description 用户信息管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/staff")
public class StaffController {
	
	StaffService staffService = new StaffService();
	public StaffController(){
	}
	
	/**
	 * @description 用户登录
	 * @return
	 */
	public String Login(){
		
		return "";
	}
	
	
	@RequestMapping(value = "/lists",method=RequestMethod.GET)
	public String GetStaffList(HttpServletRequest request){
		List<StaffEntity> list = staffService.GetStafList();
		request.setAttribute("staffList", list);
		System.out.println("lists");
		return "staff/staffList";
	}
	
	/**
	 * @descriptor 统计每个职工销售了每一样产品的数量
	 * @param staffId
	 * @param response
	 */
	@RequestMapping(value="/performance",method=RequestMethod.GET)
	public void GetStaffPerformanceById(String staffId,HttpServletResponse response){
		StaffEntity staff = staffService.GetStaffPerformanceById(staffId);
		List<ProductEntity> productList = staff.getProducts();
		String productsStr = SaleUtil.GetGsonStr(productList);
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			out.print(productsStr);
		}
		catch (IOException e) {
			System.err.print("GetStaffPerformanceById 转化成json数据出错:"+e.getMessage());
		}
		finally
		{
			out.close();
		}
	}
}	
