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
import java.util.List;

@WebServlet("/removeProduct")
public class RemoveProduct extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";

        String action = request.getParameter("action");
        if(action == null) url = "/index.html";

        if(action.equals("join")) {
            url = "/index.html";
        }
        else if(action.equals("remove")) {
            int productCode = Integer.parseInt(request.getParameter("productCode"));
            HttpSession session = request.getSession();
            List<LineProduct> cart = (List<LineProduct>) session.getAttribute("cart");
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getProduct().getProductCode() == productCode) {
                    cart.remove(i);
                    break;
                }
            }
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
