package sale.xiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * <class description>
 * 
 * @author: harrytan
 * @version: 1.0, Mar 13, 2015
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public ModelAndView helloWorld() {
        String message = "Spring 3 MVC Hello World";
        System.out.println(message);
        return new ModelAndView("jsp/hello", "message", message);
    }
}
