package com.example.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;

public class WebConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {
        //todo: 2. Configure the onStartup method.
        // init context and specify config location
        // init app context and register your MvcConfiguration
        // init dispatcherServlet
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
