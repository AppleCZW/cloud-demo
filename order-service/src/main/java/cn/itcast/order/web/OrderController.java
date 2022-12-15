package cn.itcast.order.web;


import cn.itcast.order.pojo.Order;

import cn.itcast.order.service.OrderService;
import com.cz.feign.client.UserClient;
import com.cz.feign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/order")
public class OrderController {



   @Autowired
   private OrderService orderService;
   @Autowired
   private RestTemplate restTemplate;
   @Autowired
   private UserClient userclient;

   @GetMapping("/test")
   public String test(){
       return "你好";
   }

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 1.根据id查询订单并返回
        Order order = orderService.queryOrderById(orderId);
//        //2.利用restTemplate发出请求
//        // 2.1 url路径  /user/" + order.getUserId()
//        String url = "http://userserver/user/"+order.getUserId();
//        // 2.2 发送http请求，实现远程调用
//        User user= restTemplate.getForObject(url, User.class);

        //使用Feign来远程调用
        User user = userclient.findById(order.getUserId());

        // 3 封装user到order
        order.setUser(user);
        // 4 返回
        return order;
    }



}
