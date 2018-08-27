package edu.cqupt.eini.chapter13.controller;

import edu.cqupt.eini.chapter13.po.User;
import edu.cqupt.eini.chapter13.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: Hello World
 * @date: 2018/8/25 15:23
 */
@Controller
public class UserController {
    /*@RequestMapping("/selectUser")
    public String selectUser(HttpServletRequest request) {
        String id = request.getParameter("id");
        System.out.println("id=" + id);
        return "success";
    }*/

    /*@RequestMapping("/selectUser")
    public String selectUser(Integer id) {
        System.out.println("id=" + id);
        return "success";
    }*/

    @RequestMapping("/selectUser")
    public String selectUser(@RequestParam(value = "user_id", defaultValue = "666") Integer id) {
        System.out.println("id=" + id);
        return "success";
    }

    /**
     * 向注册页面跳转
     */
    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    /**
     * 接收用户注册消息
     */
    @RequestMapping("/registerUser")
    public String registerUser(User user) {
        String username = user.getUsername();
        Integer password = user.getPassword();
        System.out.println("username=" + username);
        System.out.println("password=" + password);
        return "success";
    }

    /**
     * 向用户页面跳转
     */
    @RequestMapping("/toUser")
    public String selectUsers() {
        return "user";
    }

    /**
     * 接收批量删除用户的方法
     */
    @RequestMapping("/deleteUsers")
    public String deleteUsers(Integer[] ids) {
        if (ids != null) {
            for (Integer id : ids) {
                System.out.println("删除了id为" + id + "的用户！");
            }
        } else {
            System.out.println("ids=null");
        }
        return "success";
    }

    /**
     * 向用户批量修改页面跳转
     */
    @RequestMapping("/toUserEdit")
    public String toUserEdit() {
        return "user_edit";
    }

    /**
     * 接收批量修改用户的方法
     */
    @RequestMapping("/editUsers")
    public String editUsers(UserVo userList) {
        List<User> users = userList.getUsers();
        for (User user : users) {
            if (user.getId() != null) {
                System.out.println("修改了id为" + user.getId() +
                        "的用户名为：" + user.getUsername());
            }
        }
        return "success";
    }
}
