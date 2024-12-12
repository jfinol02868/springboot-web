package com.springboot.web.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component(value = "loadingTimeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("LoadingTimeInterceptor: preHandle() entrando ...".concat(handlerMethod.getMethod().getName()));
        long startTime =  System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        logger.info("Tiempo de inicio de la peticion: ".concat(String.valueOf(startTime)));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable  ModelAndView modelAndView) throws Exception {
        logger.info("LoadingTimeInterceptor: postHandle() saliendo ...".concat( ((HandlerMethod) handler).getMethod().getName()));
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long loadingTime = endTime - startTime;
        logger.info("LoadingTimeInterceptor: postHandle() tiempo de carga: ".concat(String.valueOf(loadingTime)).concat(" ms"));
    }
}
