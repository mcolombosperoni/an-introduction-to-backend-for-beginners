package com.mcs.be.course.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by mcolombo on 14/12/17.
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Value("${spring.view.prefix}")
    private String prefix = "";

    @Value("${spring.view.suffix}")
    private String suffix = "";

    @Value("${spring.view.view-names}")
    private String viewNames = "";

    @Value("${spring.application.name}")
    private String appName = "";

    @Value("${app.version}")
    private String appVersion = "";

    @Bean
    public ViewResolver jspViewResolver() {
        final InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix(prefix);
        vr.setSuffix(suffix);
        vr.setViewClass(JstlView.class);
        vr.setViewNames(viewNames);
        vr.setOrder(1);
        vr.getAttributesMap().put("appName", appName);
        vr.getAttributesMap().put("appVersion", appVersion + "_" + System.currentTimeMillis());
        return vr;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

}
