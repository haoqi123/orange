package com.mr.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 师利梅 on 2019/5/9.
 */

public class MyInterceptor implements HandlerInterceptor {

//    private final Logger logger = LoggerFactory.getLogger(this.getClass().getCanonicalName());
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        logger.info("{}:在请求处理之前进行调用（Controller方法调用之前）", this.getClass().getSimpleName());
//        return true;//只有返回true才会继续向下执行，返回false取消当前请求
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
//        logger.info("{}:请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）", this.getClass().getSimpleName());
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        logger.info("{}:在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）", this.getClass().getSimpleName());
//    }
}
