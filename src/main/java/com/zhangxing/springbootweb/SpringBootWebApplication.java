package com.zhangxing.springbootweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@MapperScan(value = "com.zhangxing.springbootweb.mapper")
@SpringBootApplication
@EnableCaching
@EnableRabbit
@EnableAsync
@EnableScheduling
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @Bean
    public ViewResolver zxViewResolver(){
        return new ZxViewResolver();
    }

    public static class ZxViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

    /*
    * 扩展SpringMVC只需要编写一个配置类（@Configuration），是WebMvcConfigurerAdapter
    * */

}
