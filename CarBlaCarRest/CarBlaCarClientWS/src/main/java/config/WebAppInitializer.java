package config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(1)
public class WebAppInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    public Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{CoreConfig.class};
    }

    @Override
    public Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    public String[] getServletMappings() {
        return new String[]{"/"};
    }

}