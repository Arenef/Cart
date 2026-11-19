package cart.data;

import cart.dto.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductIO {

    public static List<Product> getProducts() {
        try {
            InputStream is = ProductIO.class.getResourceAsStream("/products.json");
            Product[] products = new ObjectMapper().readValue(is, Product[].class);
            return Arrays.asList(products);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static Product getProduct(int productCode) {
        for (Product p : getProducts()) {
            if (p.getProductCode() == productCode)
                return p;
        }
        return null;
    }
}
