package sale.xiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/helloWorld")
    public ModelAndView helloWorld(Model model) {
        String message = "Hello World, Spring 3.0!";
        return new ModelAndView("hello", "message", message);
    }
}
