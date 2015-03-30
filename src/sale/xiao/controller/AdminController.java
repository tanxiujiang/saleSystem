package sale.xiao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sale.xiao.entity.AdminEntity;
import sale.xiao.entity.ProductEntity;
import sale.xiao.entity.StaffEntity;
import sale.xiao.service.AdminService;
import sale.xiao.util.SaleUtil;

/**
 * 
 * <class description> 管理员管理
 * 
 * @author: harrytan
 * @version: 1.0, Mar 25, 2015
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    AdminService adminService = null;
    
    // 这种方式添加以后在页面就使用admin.email 格式去实现传参数，否则就是email
    // @InitBinder("admin")
    // public void initBinder2(WebDataBinder binder) {
    // binder.setFieldDefaultPrefix("admin.");
    // }

    /**
     * 初始化service类，加载数据信息
     */
    @ModelAttribute
    public void initService(){
        adminService = new AdminService();
    }
    
    /**
     * 
    * <method description>
    * 做管理员登陆和职工登录入口
    * @param request
    * @param admin
    * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @ModelAttribute("admin") AdminEntity admin) {
        StaffEntity o = adminService.login(admin);
        if (null != o) {
            HttpSession session = SaleUtil.getSession(request);
            session.setAttribute("staff", o);
        }
        return "redirect:../sale/index";
    }



    @RequestMapping(value = "/gostaff", method = RequestMethod.GET)
    public String GoAddStaff() {

        return "admin/addStaff";
    }



    @RequestMapping(value = "/goproduct", method = RequestMethod.GET)
    public String GoAddProduct() {

        return "admin/addProduct";
    }



    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String AddProduct(@ModelAttribute("product") ProductEntity product, HttpServletRequest request) {
        ProductEntity p = product;
        p.setId(SaleUtil.GetProductId());
        p.setRemain_amount(product.getTotal_amount());
        boolean b = adminService.AddProducts(p);
        if (b) {
            request.setAttribute("msg", "success");
        } else {
            request.setAttribute("msg", "failure");
        }
        request.setAttribute("product", p);
        return "admin/addProduct";
    }



    /**
     * 
     * <method description> 加载商店信息，以关于职工信息
     * 
     * @param response
     */
    @RequestMapping(value = "/loadStores", method = RequestMethod.POST)
    public void GetStoreList(HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String storeStr = adminService.GetStores();
            System.out.println(new String(storeStr.getBytes(), "UTF-8"));
            out.print(storeStr);
        } catch (IOException e) {
            System.err.print("获取商店消息失败" + e.getMessage());
        } finally {
            out.close();
        }
    }


    /**
     * 
     * <method description> 添加职工
     * 
     * @return
     */
    @RequestMapping(value = "/addstaff", method = RequestMethod.POST)
    public String AddStaff(HttpServletRequest request, @ModelAttribute StaffEntity staff) {
        boolean b = adminService.AddStaff(staff);
        if (b) {
            request.setAttribute("msg", "success");
        } else {
            request.setAttribute("msg", "failure");
        }
        request.setAttribute("staff", staff);
        return "admin/addStaff";
    }
    
    /**
     * 
    * <method description>
    *   加载职工列表
    * @param request
    * @return
     */
    @RequestMapping(value = "/stafflist", method = RequestMethod.GET)
    public String StaffList(HttpServletRequest request){
        List<StaffEntity> staffs = adminService.GetStaffs();
        request.setAttribute("staffs", staffs);
        return "admin/staffList";
    }
    
    /**
     * 
    * <method description>
    * 加载产品列表
    * @param request
    * @return
     */
    @RequestMapping(value = "/productlist", method = RequestMethod.GET)
    public String ProductList(HttpServletRequest request){
        List<ProductEntity>  products = adminService.GetProducts();
        System.out.println(products.size());
        request.setAttribute("products", products);
        return "admin/productList";
    }
    
    /**
     * 
    * <method description>
    * 统计报销分析
    * @param request
    * @param staffId
     */
    @RequestMapping(value = "/loadPerformanceByStaffId", method = RequestMethod.POST)
    public void LoadPerformanceByStaffId(HttpServletResponse response,String staffId){
        String performanceStr = adminService.LoadPerformanceByStaffId(staffId);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.print(performanceStr);
        } catch (IOException e) {
            System.err.println("查询员工产品销售报表失败");
            e.printStackTrace();
        }
        finally{
            out.close();
        }
        
    }
}
