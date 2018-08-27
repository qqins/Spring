package edu.cqupt.eini.chapter14.controller;

import edu.cqupt.eini.chapter14.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Hello World
 * @date: 2018/8/26 15:11
 */
@Controller
public class UserController {
    @RequestMapping("/testJson")
    @ResponseBody
    public User testJson(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User selectUser(@PathVariable("id") String id) {
        System.out.println("id=" + id);
        User user = new User();
        if (id.equals("1234")) {
            user.setUsername("qqin");
        }
        return user;
    }
}
