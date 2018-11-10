package gamesRenting.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class gamesRentingInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected String[] getServletMappings(){
        return new String[]{"/"};
    }
    protected Class<?>[] getRootConfigClasses(){
        return new Class<?>[]{rootConfig.class,cacheConfig.class,securityConfig.class};
    }
    protected Class<?>[] getServletConfigClasses(){
        return new Class<?>[]{servletConfig.class};
    }
}
