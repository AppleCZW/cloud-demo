package cn.itcast.order.pojo;

import com.cz.feign.pojo.User;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private User user;
}
