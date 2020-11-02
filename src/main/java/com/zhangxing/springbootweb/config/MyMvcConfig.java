package com.zhangxing.springbootweb.config;

//import com.zhangxing.springbootweb.resolver.MyLocalResolver;

import com.zhangxing.springbootweb.component.LoginHandlerInterceptor;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author zhangxing
 * @Description: 扩展SpringMVC
 * @date 2020/10/28 21:53
 */

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {




    //扩展SpringMVC，既保留了自动配置，也能用扩展配置
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/testAddMvc").setViewName("success");
    }

//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocalResolver();
//    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/login.html", "/index", "/", "/user/login");
//                //一些情况下可能需要排除静态资源 "/static/css/**","/webjars/**
//            }
        };
        return adapter;
    }
}
