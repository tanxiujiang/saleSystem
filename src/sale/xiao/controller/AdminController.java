package sale.xiao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sale.xiao.entity.AdminEntity;
import sale.xiao.entity.ProductEntity;
import sale.xiao.entity.StaffEntity;
import sale.xiao.entity.StoreEntity;
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

    // 这种方式添加以后在页面就使用admin.email 格式去实现传参数，否则就是email
    // @InitBinder("admin")
    // public void initBinder2(WebDataBinder binder) {
    // binder.setFieldDefaultPrefix("admin.");
    // }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @ModelAttribute("admin") AdminEntity admin) {
        AdminService adminService = new AdminService();
        AdminEntity o = adminService.login(admin);
        if (null != o) {
            HttpSession session = SaleUtil.getSession(request);
            session.setAttribute("admin", o);
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
        p.setRemain_amount(product.getTotal_amount());
        AdminService adminService = new AdminService();
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
    * <method description>
    * 加载商店信息，以关于职工信息
    * @param response
     */
    @RequestMapping(value = "/loadStores", method = RequestMethod.POST)
    public void GetStoreList(HttpServletResponse response){
        PrintWriter out = null;
        try {
            AdminService adminService = new AdminService();
            out = response.getWriter();
            String storeStr  = adminService.GetStores();
            System.out.println(new String(storeStr.getBytes(),"UTF-8"));
            out.print(storeStr);
        } catch (IOException e)
        {
            System.err.print("获取商店消息失败"+e.getMessage());
        }
        finally{
            out.close();
        }
    }
    
    /**
     * 
    * <method description>
    *   添加职工
    * @return
     */
    @RequestMapping(value = "/addstaff", method = RequestMethod.POST)
    public String AddStaff(@ModelAttribute StaffEntity staff){
        
        return "admin/addStaff";
    }
    
}
