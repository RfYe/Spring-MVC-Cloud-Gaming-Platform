package gamesRenting.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import javax.sql.DataSource;

@Configuration
@EnableWebMvcSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {
    DataSource dataSource;
    AuthenticationSuccessHandler ash;
    @Autowired
    public securityConfig(DataSource dataSource,AuthenticationSuccessHandler ash){
        this.dataSource=dataSource;
        this.ash=ash;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin().loginPage("/login").usernameParameter("userName").passwordParameter("password").successHandler(ash).and().csrf().csrfTokenRepository(csrfTokenRepository()).and().rememberMe().authenticationSuccessHandler(ash).and().authorizeRequests().antMatchers("/mylibrary").hasAuthority("ROLE_USER").antMatchers("/addtolibrary/*").hasAuthority("ROLE_USER").antMatchers("/addGame").hasAuthority("ROLE_ADMIN").anyRequest().permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
    }
     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception{
         auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("SELECT userName,password,enabled FROM User WHERE userName=?").authoritiesByUsernameQuery("SELECT userName,role FROM User where userName=?").getUserDetailsService();
     }
    private CsrfTokenRepository csrfTokenRepository()
    {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }
}
