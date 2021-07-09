package az.mycompany.TechnoMarket.servlet;

import az.mycompany.TechnoMarket.db.UserRepo;
import az.mycompany.TechnoMarket.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registration", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = new Users();
        UserRepo repo = new UserRepo();

        if (repo.existByUsername(req.getParameter("username"))) {
            resp.sendRedirect("usernameError.jsp");
        }
        else if( repo.existByEmail(req.getParameter("email"))){

        }
        else if(repo.existByPhone(req.getParameter("phone"))){

        }
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        repo.addUser(user);
        resp.sendRedirect("login.html");
    }
}
