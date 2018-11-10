package gamesRenting.config;

import gamesRenting.persistence.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class customizedSuccessHandler implements AuthenticationSuccessHandler {
    private static final RedirectStrategy REDIRECT_STRATEGY = new DefaultRedirectStrategy();
    private usersRepository ur;
    @Autowired
    public customizedSuccessHandler(usersRepository ur){
        this.ur=ur;
    }
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {
        org.springframework.security.core.userdetails.User user=(org.springframework.security.core.userdetails.User)authentication.getPrincipal();
        String username=user.getUsername();
        int id=ur.getUserIdByUserName(username);
        httpServletRequest.getSession().setAttribute("id",id);
        try {
            REDIRECT_STRATEGY.sendRedirect(httpServletRequest, httpServletResponse, "/");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
