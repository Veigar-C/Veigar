package com.veigar.Interceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2018/1/6.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String URL = request.getRequestURI();
        String Path = request.getContextPath();

        String targetURL = URL.substring(Path.length());
        HttpSession session = request.getSession(false);

        if(targetURL.indexOf("index.jsp")>0 || targetURL.equals("/")){
            filterChain.doFilter(request,response);
        }else {
            if(session == null || session.getAttribute("username") ==null){
                response.sendRedirect("index.jsp");
            }else {
                filterChain.doFilter(request,response);
            }
         }
    }

    @Override
    public void destroy() {

    }
}
