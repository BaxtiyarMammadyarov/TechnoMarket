package az.mycompany.TechnoMarket.servlet;


import az.mycompany.TechnoMarket.db.UserRepo;
import az.mycompany.TechnoMarket.model.Users;
import az.mycompany.TechnoMarket.util.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "login",value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        PasswordEncoder encoder=new PasswordEncoder();
        UserRepo repo=new UserRepo();
        Users user;
        if(!repo.existByUsername("username")){
            PrintWriter print= resp.getWriter();
            print.println("<html><body>" +
                    "<h2 >İstifadəçi adı mövcud deyil</h2>" +
                    " <ul>" +
                    "<li><a href='login.html' >Giriş</a></li>" +
                    " <li><a href='index.jsp' >Əsas səhifə</a></li>" +
                    " <li><a href='registration.html'>Qeydiyyat</a></li>" +
                    " </ul>" +
                    "</body></html>");

        }
        user= repo.getByUser(username);
        if(!user.getPassword().equals(encoder.passwordEncoder(password))){
            PrintWriter print= resp.getWriter();
            print.println("<html><body>" +
                    "<h2 >Şifrə yanlışdir</h2>" +
                    " <ul>" +
                    "<li><a href='login.html' >Giriş</a></li>" +
                    " <li><a href='index.jsp' >Əsas səhifə</a></li>" +
                    " <li><a href='registration.html'>Qeydiyyat</a></li>" +
                    " </ul>" +
                    "</body></html>");

        }
        HttpSession session=req.getSession();
        session.setAttribute("user",user);
        session.setMaxInactiveInterval(60);
        Cookie cookie=new Cookie("username",username);
        cookie.setMaxAge(60);
        resp.addCookie(cookie);
        resp.sendRedirect("Home.jsp");





    }
}
