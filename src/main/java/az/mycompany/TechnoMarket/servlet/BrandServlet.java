package az.mycompany.TechnoMarket.servlet;


import az.mycompany.TechnoMarket.model.Brand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



import java.time.LocalDateTime;

@WebServlet(name = "insertBrand",value = "/insertBrand")
public class BrandServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Brand brand=new Brand();
        brand.setName(req.getParameter("brandName"));
        brand.setDateTime(LocalDateTime.now());
        brand.setEnabled(true);
        resp.getWriter().println("<h1>"+brand.getName()+"</h1>");




    }
}

