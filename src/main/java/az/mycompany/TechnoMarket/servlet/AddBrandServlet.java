package az.mycompany.TechnoMarket.servlet;

import az.mycompany.TechnoMarket.db.BrandRepo;
import az.mycompany.TechnoMarket.model.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/brand/add")
public class AddBrandServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BrandRepo repo =new BrandRepo();
        Brand brand=repo.getByName(req.getParameter("brandName"));
        if(brand==null){
        brand.setName(req.getParameter("brandName"));

        repo.add(brand);
        }

    }
}
