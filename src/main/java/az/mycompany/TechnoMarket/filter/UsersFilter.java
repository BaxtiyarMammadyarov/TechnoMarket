package az.mycompany.TechnoMarket.filter;

import az.mycompany.TechnoMarket.model.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UsersFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        String requestUri=request.getRequestURI();
        Users user= (Users) request.getSession().getAttribute("user");
        String status=user.getStatus();

        if((!status.equals("admin")||!status.equals("user"))&&!requestUri.equals("/login.html")&&!requestUri.equals("/")){
           response.sendRedirect("login.html");

        }else if(status.equals("user")
                &&!requestUri.equals("/")
                &&!requestUri.equals("/login")
                &&!requestUri.equals("/logout")
                &&!requestUri.equals("Home.jsp")) {

            response.sendRedirect("login.html");
        }
        else {
            filterChain.doFilter(request,response);
        }
    }
}
