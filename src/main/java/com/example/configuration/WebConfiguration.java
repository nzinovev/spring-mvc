package com.example.configuration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        var rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.setConfigLocation("com.example.configuration");
        servletContext.addListener(new ContextLoaderListener(rootContext));

        var servletAppContext = new AnnotationConfigWebApplicationContext();
        servletAppContext.register(MvcConfiguration.class);

        var dispatcherServlet = new DispatcherServlet(servletAppContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    protected String[] getServletMappings() {
        return new String[0];
    }
}
