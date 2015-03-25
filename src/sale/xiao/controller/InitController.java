package sale.xiao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sale.xiao.util.SaleUtil;

@Controller
@RequestMapping("/sale")
public class InitController {

    @RequestMapping(value = "/index",method=RequestMethod.GET)
    public String Index(HttpServletRequest request){
        return "sale/index";
    } 
}
