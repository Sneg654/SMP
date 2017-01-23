package com.smp.config;

import com.smp.config.filter.EncondingFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by Sergey_Stefoglo on 1/15/2017.
 */
public class SMPWebIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class, DBConfig.class, MailConf.class};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        registerCharacterEncodingFilter(servletContext);
    }
    private void registerCharacterEncodingFilter(final ServletContext servletContext) {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic filter = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        filter.addMappingForUrlPatterns(null, true, "/*");
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*@Override
    protected Filter[] getServletFilters() {
        Filter[] filters;

        CharacterEncodingFilter encFilter;
        HiddenHttpMethodFilter httpMethodFilter = new HiddenHttpMethodFilter();
        EncondingFilter encondingFilter=new  EncondingFilter();
        encFilter = new CharacterEncodingFilter();

        encFilter.setEncoding("UTF-8");
        encFilter.setForceEncoding(true);

        filters = new Filter[] {httpMethodFilter, encFilter};
        return filters;
    }*/

}
