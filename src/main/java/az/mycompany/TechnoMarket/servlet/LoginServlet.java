package az.mycompany.TechnoMarket.servlet;


import az.mycompany.TechnoMarket.db.UserRepo;
import az.mycompany.TechnoMarket.model.Users;
import az.mycompany.TechnoMarket.util.PasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;



@WebServlet(name = "login",value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        PasswordEncoder encoder=new PasswordEncoder();
        UserRepo repo=new UserRepo();
        Users user=repo.getByUser(username);
        if(user==null){
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
            resp.getWriter().println("<font color=red>Istifadeci adi movcud deyil</font>");
            requestDispatcher.include(req, resp);

        }else {

            if (user.getPassword().equals(encoder.passwordEncoder(password))) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(6000);
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(6000);
                resp.addCookie(cookie);
                resp.sendRedirect("Home.jsp");
            }
            else{
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/login.html");
                resp.getWriter().println("<font color=red>Şifrə yanlişdir</font>");
                requestDispatcher.include(req, resp);
            }
        }
    }
}
