package az.mycompany.TechnoMarket.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie loginCookie = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    loginCookie = cookie;
                    break;
                }
            }
        }

        HttpSession httpSession = req.getSession(false);
        if (httpSession != null){
            httpSession.invalidate();
        }

        if (loginCookie != null) {
            loginCookie.setMaxAge(0);
            resp.addCookie(loginCookie);
        }
        resp.sendRedirect("index.jsp");
    }
}
