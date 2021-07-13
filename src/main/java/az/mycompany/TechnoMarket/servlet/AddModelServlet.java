package az.mycompany.TechnoMarket.servlet;

import az.mycompany.TechnoMarket.db.ModelRepo;
import az.mycompany.TechnoMarket.model.Brand;
import az.mycompany.TechnoMarket.model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/model/add")
public class AddModelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModelRepo repo= new ModelRepo();
        Model model=repo.getByModel(req.getParameter("name"));
        if(model==null){
            model.setName(req.getParameter("name"));
            Brand brand=new Brand();
            brand.setName(req.getParameter("brand_name"));
            model.setBrand(brand);
            repo.add(model);
        }
    }
}
