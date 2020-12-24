package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.JWTUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureException;

public class JWTFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        

        System.out.print(req.getRequestURI()); //retorna a url
        System.out.print(req.getRequestURI().startsWith("/api/login")); // compara se a url é igual 
        
        
        if(req.getRequestURI().startsWith("/RESTCarroJWT/api/login")){
            filterChain.doFilter(servletRequest, servletResponse); // chama a função JWTUtil
            return;
        }
        
        // Pega o token do cabeçalho
        String token = req.getHeader(JWTUtil.TOKEN_HEADER);
        
        // vefica se token é diferente de null ou ""
        if(token == null || token.trim().isEmpty()){
            res.setStatus(401);
            return;
        }

        // valida se o token é válido
        try {
            Jws<Claims> parser = JWTUtil.decode(token);
            System.out.println("User request: "+ parser.getBody().getSubject());
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (SignatureException e) {
            res.setStatus(401);
        }

    }

    @Override
    public void destroy() {}
}
