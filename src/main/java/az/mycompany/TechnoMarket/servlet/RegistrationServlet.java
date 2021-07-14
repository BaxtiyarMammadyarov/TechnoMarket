package az.mycompany.TechnoMarket.servlet;

import az.mycompany.TechnoMarket.db.UserRepo;
import az.mycompany.TechnoMarket.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registration", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Users user;
    private UserRepo repo;

    @Override
    public void init() throws ServletException {
        user=new Users();
        repo=new UserRepo();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pr=resp.getWriter();
        String username=req.getParameter("username");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");

        if (repo.existByUsername(username)) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/registration.html");
            resp.getWriter().println("<font color=red>Istifadeci adi movcuddur</font>");
            requestDispatcher.include(req, resp);
        }
        else if (repo.existByEmail(email)) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/registration.html");
            resp.getWriter().println("<font color=red>e,email movcuddur!!!</font>");
            requestDispatcher.include(req, resp);
        }
        else if (repo.existByPhone(phone)) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/registration.html");
            resp.getWriter().println("<font color=red>Telefon nomresi movcuddur</font>");
            requestDispatcher.include(req, resp);
        }
        else {
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
}
