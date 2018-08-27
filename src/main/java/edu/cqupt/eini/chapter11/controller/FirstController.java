package edu.cqupt.eini.chapter11.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Hello World
 * @date: 2018/8/19 11:05
 */
public class FirstController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav=new ModelAndView();
        mav.addObject("msg","Hello World Spring MVC");
        mav.setViewName("/WEB-INF/jsp/first.jsp");
        return mav;
    }
}
