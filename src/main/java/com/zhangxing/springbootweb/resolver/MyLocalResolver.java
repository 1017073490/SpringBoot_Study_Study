//package com.zhangxing.springbootweb.resolver;
//
//import org.springframework.util.StringUtils;
//import org.springframework.web.servlet.LocaleResolver;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Locale;
//
///**
// * @author zhangxing
// * @Description: 配置自己的区域解析器
// * 在链接上连上自己的区域信息
// * @date 2020/10/29 10:01
// */
//public class MyLocalResolver implements LocaleResolver {
//    @Override
//    public Locale resolveLocale(HttpServletRequest request) {
//        String l = request.getParameter("l");
//        Locale locale = null;
//        if (!StringUtils.isEmpty(l)) {
//            String[] split = l.split("_");
//            locale = new Locale(split[0], split[1]);
//        }
//        return locale;
//    }
//
//    @Override
//    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
//
//    }
//}
