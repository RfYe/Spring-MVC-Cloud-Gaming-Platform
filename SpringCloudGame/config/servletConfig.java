package gamesRenting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
@Configuration
@EnableWebMvc
@ComponentScan("gamesRenting.webComponents")
public class servletConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver){
        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }
    @Bean
    public TemplateResolver templateResolver(){
        TemplateResolver templateResolver=new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/view/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }
    @Override
public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configure){
    configure.enable();
}
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("view/js/fancybox/*").addResourceLocations("/WEB-INF/view/js/fancybox/");
        registry.addResourceHandler("view/js/*").addResourceLocations("/WEB-INF/view/js/");
        registry.addResourceHandler("view/font/fonts/*").addResourceLocations("/WEB-INF/view/font/fonts/");
        registry.addResourceHandler("view/font/css/*").addResourceLocations("/WEB-INF/view/font/css/");
        registry.addResourceHandler("view/font/less/*").addResourceLocations("/WEB-INF/view/font/less/");
        registry.addResourceHandler("view/font/scss/*").addResourceLocations("/WEB-INF/view/font/scss/");
        registry.addResourceHandler("view/css/*").addResourceLocations("/WEB-INF/view/css/");
        registry.addResourceHandler("view/images/*").addResourceLocations("/WEB-INF/view/images/");
        registry.addResourceHandler("view/fonts/*").addResourceLocations("/WEB-INF/view/fonts/");
        registry.addResourceHandler("view/loginassets/bootstrap/css/*").addResourceLocations("/WEB-INF/view/loginassets/bootstrap/css/");
        registry.addResourceHandler("view/loginassets/bootstrap/fonts/*").addResourceLocations("/WEB-INF/view/loginassets/bootstrap/fonts/");
        registry.addResourceHandler("view/loginassets/bootstrap/js/*").addResourceLocations("/WEB-INF/view/loginassets/bootstrap/js/");
        registry.addResourceHandler("view/loginassets/css/*").addResourceLocations("/WEB-INF/view/loginassets/css/");
        registry.addResourceHandler("view/loginassets/ico/*").addResourceLocations("/WEB-INF/view/loginassets/ico/");
        registry.addResourceHandler("view/loginassets/js/*").addResourceLocations("/WEB-INF/view/loginassets/js/");
        registry.addResourceHandler("view/loginassets/font-awesome/css/*").addResourceLocations("/WEB-INF/view/loginassets/font-awesome/css/");
        registry.addResourceHandler("view/loginassets/font-awesome/fonts/*").addResourceLocations("/WEB-INF/view/loginassets/font-awesome/fonts/");
        registry.addResourceHandler("view/loginassets/font-awesome/less/*").addResourceLocations("/WEB-INF/view/loginassets/font-awesome/less/");
        registry.addResourceHandler("view/loginassets/font-awesome/scss/*").addResourceLocations("/WEB-INF/view/loginassets/font-awesome/scss/");
        registry.addResourceHandler("view/loginassets/img/backgrounds/*").addResourceLocations("/WEB-INF/view/loginassets/img/backgrounds/");
        registry.addResourceHandler("view/registerassets/bootstrap/css/*").addResourceLocations("/WEB-INF/view/registerassets/bootstrap/css/");
        registry.addResourceHandler("view/registerassets/bootstrap/fonts/*").addResourceLocations("/WEB-INF/view/registerassets/bootstrap/fonts/");
        registry.addResourceHandler("view/registerassets/bootstrap/js/*").addResourceLocations("/WEB-INF/view/registerassets/bootstrap/js/");
        registry.addResourceHandler("view/registerassets/css/*").addResourceLocations("/WEB-INF/view/registerassets/css/");
        registry.addResourceHandler("view/registerassets/ico/*").addResourceLocations("/WEB-INF/view/registerassets/ico/");
        registry.addResourceHandler("view/registerassets/js/*").addResourceLocations("/WEB-INF/view/registerassets/js/");
        registry.addResourceHandler("view/registerassets/font-awesome/css/*").addResourceLocations("/WEB-INF/view/registerassets/font-awesome/css/");
        registry.addResourceHandler("view/registerassets/font-awesome/fonts/*").addResourceLocations("/WEB-INF/view/registerassets/font-awesome/fonts/");
        registry.addResourceHandler("view/registerassets/font-awesome/less/*").addResourceLocations("/WEB-INF/view/registerassets/font-awesome/less/");
        registry.addResourceHandler("view/registerassets/font-awesome/scss/*").addResourceLocations("/WEB-INF/view/registerassets/font-awesome/scss/");
        registry.addResourceHandler("view/registerassets/img/backgrounds/*").addResourceLocations("/WEB-INF/view/registerassets/img/backgrounds/");
        registry.addResourceHandler("view/registerassets/img/*").addResourceLocations("/WEB-INF/view/registerassets/img/");
    }
}
