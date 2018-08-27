package edu.cqupt.eini.chapter13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author: Hello World
 * @date: 2018/8/25 17:31
 */
@Controller
public class DateController {
    @RequestMapping("/customDate")
    public String CustomDate(Date date) {
        System.out.println("date=" + date);
        return "success";
    }
}
