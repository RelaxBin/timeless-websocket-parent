package com.timeless.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setCharacterEncoding("UTF-8");
        //配置来源 '*'
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        //允许获取证书
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //配置请求方法
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,PUT,DELETE");
        //配置请求头，如果有自定义的请求头，必须配置
        response.setHeader("Access-Control-Allow-Headers",
                "Content-type, X-Requested-With, Authorization, myKey, my-Date, Content-xxx, Accept");
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        response.setHeader("Access-Control-Max-Age", "3600");
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
