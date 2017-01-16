package com.smp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

/**
 * Created by Sergey_Stefoglo on 1/15/2017.
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.smp"})
public class RootConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }


    @Bean
    public VelocityLayoutViewResolver velocityLayoutViewResolver() {
        VelocityLayoutViewResolver resolver = new VelocityLayoutViewResolver();
        resolver.setLayoutUrl("layout.vm");
        resolver.setSuffix(".vm");
        return resolver;
    }

    /**
     * Velocity Template Engine Configurer.
     * See: http://velocity.apache.org/
     *
     * @return velocity configurer
     */
    @Bean
    public VelocityConfigurer velocityConfigurer() {
        VelocityConfigurer conf = new VelocityConfigurer();
        conf.setResourceLoaderPath("/WEB-INF/views/");
        return conf;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(1_250_000); // 10 MB
        return resolver;
    }
}