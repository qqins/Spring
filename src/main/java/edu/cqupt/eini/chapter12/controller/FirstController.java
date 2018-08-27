package edu.cqupt.eini.chapter12.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Hello World
 * @date: 2018/8/19 11:05
 *
 * 使用注解的形式
 */
@Controller
public class FirstController {
    //value是默认属性，可以省略不写
    /*@RequestMapping(value = "/firstController")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg","Hello World Spring MVC TOO");
        mav.setViewName("/WEB-INF/jsp/first.jsp");
        return mav;
    }*/

    @RequestMapping(value = "/firstController")
    public String handleRequest(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Model model) throws Exception {
        model.addAttribute("msg", "Hello World Spring MVC String");
//        return "/WEB-INF/jsp/first.jsp";
        return "first";
    }
}
