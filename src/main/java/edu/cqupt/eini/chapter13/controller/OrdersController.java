package edu.cqupt.eini.chapter13.controller;

import edu.cqupt.eini.chapter13.po.Orders;
import edu.cqupt.eini.chapter13.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Hello World
 * @date: 2018/8/25 16:56
 */
@Controller
public class OrdersController {

    @RequestMapping("/tofindOrdersWithUser")
    public String tofindOrdersWithUser() {
        return "orders";
    }

    @RequestMapping("/findOrdersWithUser")
    public String findOrdersWithUser(Orders orders) {
        Integer ordersId = orders.getOrdersId();
        User user = orders.getUser();
        String username = user.getUsername();
        System.out.println("ordersId=" + ordersId);
        System.out.println("username=" + username);
        return "success";
    }
}
