package edu.cqupt.eini.chapter02.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author: Hello World
 * @date: 2018/7/27 11:11
 */
@Controller("userController")
public class UserController {
    @Resource(name = "userService")
//    @Autowired
    private UserService userService;

    public void save() {
        userService.save();
        System.out.println("userController...save...");
    }
    /*public void setUserService(UserService userService) {
        this.userService = userService;
    }*/
}
