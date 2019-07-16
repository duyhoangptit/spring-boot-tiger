package vn.hoangptit.tiger.core.config.security;


import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create file CorsFilter
 *
 * @author duyhoangptit
 * @since 7/4/2019
 */
@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, DELETE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Headers",
                "Origin, Authorization, X-Requested-With, Content-Type, Accept-Language");
        response.setHeader("Access-Control-Max-Age", "3600");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) {
            response.setStatus(200);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
