package edu.cqupt.eini.chapter15.controller;

import edu.cqupt.eini.chapter15.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author: Hello World
 * @date: 2018/8/27 11:22
 */
@Controller
public class UserController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        String username = user.getUsername();
        String password = user.getPassword();
        //此处模拟从数据库中获取用户名和密码后进行判断
        if (username != null && username.equals("qqin")
                && password != null && password.equals("666888")) {
            //将用户对象加到session
            session.setAttribute("USER_SESSION", user);
            //重定向到主页面的跳转方法
            return "redirect:main";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "login";
    }

    /**
     * 向用户主页面跳转
     */
    @RequestMapping(value = "/main")
    public String toMain() {
        return "main";
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        //清除session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:login";
    }
}
