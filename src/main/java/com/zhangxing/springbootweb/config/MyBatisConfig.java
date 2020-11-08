package com.zhangxing.springbootweb.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/4 9:40
 */

@org.springframework.context.annotation.Configuration
public class MyBatisConfig {

    //开启驼峰命名法
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer(){
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
