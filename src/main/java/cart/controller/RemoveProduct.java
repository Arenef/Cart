package cart.controller;

import cart.dto.Cart;
import cart.dto.LineProduct;
import cart.dto.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/removeProduct")
public class RemoveProduct extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";

        String action = request.getParameter("action");
        if(action == null) url = "/index.jsp";

        if(action.equals("join")) {
            url = "/index.jsp";
        }
        else if(action.equals("remove")) {
            int productCode = Integer.parseInt(request.getParameter("productCode"));
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            cart.removeProduct(productCode);
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
