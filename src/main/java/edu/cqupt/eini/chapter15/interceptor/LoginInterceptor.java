package edu.cqupt.eini.chapter15.interceptor;

import edu.cqupt.eini.chapter15.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: Hello World
 * @date: 2018/8/27 11:31
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        //除了login.jsp是可以公开访问的，其他的URL都进行拦截
        if (url.indexOf("/login") >= 0) {
            return true;
        }
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if (user != null) {
            return true;
        }
        httpServletRequest.setAttribute("msg", "您还没有登录，请先登录！");
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
