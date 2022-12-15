package cn.itcast.user.web;


import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope //完成nacos热更新
public class UserController {

    @Autowired
    private UserService userService;


//    @Value("${pattern.dateformat}")
//    private String dateformat;

//    @Autowired
//    private PatternProperties properties;
//
//    @GetMapping("prop")
//    public PatternProperties properties(){
//        return properties;
//    }

//    @GetMapping("now")
//    public String now(){
//        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
//    }

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
