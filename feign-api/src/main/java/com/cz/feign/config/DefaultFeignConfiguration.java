package com.cz.feign.config;

/*
@author cz

*/

import feign.Logger;
import org.springframework.context.annotation.Bean;

//@FeignClient("userservice") //只针对里面的服务有效
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel(){
    return Logger.Level.BASIC;
    }
}
