package az.mycompany.TechnoMarket.servlet;

import az.mycompany.TechnoMarket.model.Users;
import az.mycompany.TechnoMarket.util.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registration",value = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Users user =new Users();
        PasswordEncoder encoder=new PasswordEncoder();

       user.setName(req.getParameter("name"));
       user.setSurname(req.getParameter("surname"));
       user.setEmail(req.getParameter("email"));
       user.setPhone(req.getParameter("phone"));

       user.setUsername(req.getParameter("username"));
       user.setPassword(encoder.passwordEncoder(req.getParameter("password")));
       user.setRole("user");
      resp.sendRedirect("login.html");
    }
}
