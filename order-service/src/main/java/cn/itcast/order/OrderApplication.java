package cn.itcast.order;



import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.cz.feign.client.UserClient;
import com.cz.feign.config.DefaultFeignConfiguration;
import com.netflix.loadbalancer.IRule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
//下面如果要实例的话 需要加上clients端的类，从其他包中得到实例对象
@EnableFeignClients(clients = UserClient.class,defaultConfiguration = DefaultFeignConfiguration.class)//这样子将是全局有效
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * 创建RestTemplate并注入到Spring容器
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
    return new RestTemplate();
    }

    /**
     * 这种bean是全局的配置
     * @return
     */
    @Bean
    public IRule randomRule(){
        return new NacosRule();
    }
}
