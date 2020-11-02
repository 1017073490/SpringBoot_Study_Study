package com.zhangxing.springbootweb.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @author zhangxing
 * @Description: 在容器中加入我们自己定义的ErrorAttributies
 * @date 2020/11/2 15:27
 */
//自己定义的需要该注解，用于加入容器中
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        Map<String, Object> ext = (Map<String, Object>) requestAttributes.getAttribute("ext", 0);
        map.put("owner", "nuist.zhangxing");
        map.put("ext",ext);

        return map;
    }
}
