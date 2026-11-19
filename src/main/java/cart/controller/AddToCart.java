package cart.controller;

import cart.dto.LineProduct;
import cart.dto.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {
    @Override
    public void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";
        String action = request.getParameter("action");

        if (action == null) {
            action = "join";
        }
        else if (action.equals("add")){
            int productCode = Integer.parseInt(request.getParameter("productCode"));
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            HttpSession session = request.getSession();
            Product product = new Product(productCode, description, price);

            List<LineProduct> cart = (List<LineProduct>) session.getAttribute("cart");
            if (cart == null) cart = new ArrayList<>();

            boolean isAdded = false;
            for(LineProduct lp: cart) {
                if (lp.getProduct().getProductCode() == product.getProductCode()) {
                    lp.setQuantity(lp.getQuantity() + 1);
                    isAdded = true;
                    break;
                }
            }

            if (!isAdded) {
                LineProduct lineProduct = new LineProduct(product, 1);
                cart.add(lineProduct);
            }
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
