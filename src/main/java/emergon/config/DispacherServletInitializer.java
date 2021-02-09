/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author gkolo
 */
public class DispacherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //MyDispatcherServletConfiguration
        Class [] myServletConfigurationClasses = {MyDispatcherServletConfiguration.class};
        return myServletConfigurationClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String [] myServletMappings = {"/"};
        return myServletMappings;
    }
    
}
