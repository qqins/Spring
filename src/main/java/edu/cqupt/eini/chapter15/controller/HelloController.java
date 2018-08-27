package edu.cqupt.eini.chapter15.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Hello World
 * @date: 2018/8/27 10:29
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello!");
        return "success";
    }
}
