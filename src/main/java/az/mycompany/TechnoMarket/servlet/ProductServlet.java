package az.mycompany.TechnoMarket.servlet;

import az.mycompany.TechnoMarket.db.ProductRepo;
import az.mycompany.TechnoMarket.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductRepo repo=new ProductRepo();
        List<Product> products= repo.get();

    }
}
