package com.cykj.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {

    private ApplicationContext app;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //Servlet中本来不能使用@Autowired注入bean，解决办法是在Servlet的init（ServletConfig）方法中调用
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
        app = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }
    public Object getObject(Class c) {
        return app.getBean(c);
    }

}
