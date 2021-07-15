package az.mycompany.TechnoMarket.servlet;

import az.mycompany.TechnoMarket.db.ProductRepo;
import az.mycompany.TechnoMarket.model.Brand;
import az.mycompany.TechnoMarket.model.Model;
import az.mycompany.TechnoMarket.model.Product;
import az.mycompany.TechnoMarket.util.Conversion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;


@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
    private ProductRepo repo;

    @Override
    public void init() throws ServletException {
        repo=new ProductRepo();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product product =repo.getByNameAndColor(req.getParameter("name"),req.getParameter("color"));
        Conversion conversion=new Conversion();
        if(product==null){
            product.setName(req.getParameter("name"));
            product.setColor(req.getParameter("color"));
            product.setPrice(BigDecimal.valueOf(Double.parseDouble(req.getParameter("price"))));
            product.setType(req.getParameter("type"));
            product.setPhoto(conversion.convertImageToString(new File(req.getParameter("image"))));
            Model model=new Model();
            model.setName(req.getParameter("model"));
            Brand brand=new Brand();
            brand.setName(req.getParameter("brand"));
            model.setBrand(brand);
            product.setModel(model);
            product.setCountProduct(Integer.parseInt(req.getParameter("count")));
            repo.add(product);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/addProduct.html");
            resp.getWriter().println("<font color=red>Məhsul əlavə edildi!!!</font>");
            requestDispatcher.include(req, resp);
        }
        else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/addProduct.html");
            resp.getWriter().println("<font color=red>Məhsul mövcuddur!!!</font>");
            requestDispatcher.include(req, resp);
        }
    }
}
