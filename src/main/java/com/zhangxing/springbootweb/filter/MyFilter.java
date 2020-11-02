package com.zhangxing.springbootweb.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zhangxing
 * @Description:
 * @date 2020/11/2 16:34
 */
public class  MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("myFilter process....");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
