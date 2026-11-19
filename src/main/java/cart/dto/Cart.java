package cart.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    private List<LineProduct> cart;

    public Cart(){
        this.cart = new ArrayList<>();
    }
    public Cart(List<LineProduct> cart){
        this.cart = new ArrayList<>();
        this.cart = cart;
    }

    public List<LineProduct> getCart() {
        return cart;
    }

    public void setCart(List<LineProduct> cart) {
        this.cart = cart;
    }

    public void addProduct(LineProduct lineProduct){
        boolean isAdded = false;
        for(int i = 0 ; i < cart.size() ; i++) {
            if (cart.get(i).getProduct().getProductCode() == lineProduct.getProduct().getProductCode()){
                cart.get(i).setQuantity(cart.get(i).getQuantity() + 1);
                isAdded = true;
                break;
            }
        }
        if (!isAdded) cart.add(lineProduct);
    }

    public void updateQuantity(int productCode, int quantity){
        for (int i = 0 ; i < cart.size() ; i++) {
            if(cart.get(i).getProduct().getProductCode() == productCode) {
                cart.get(i).setQuantity(quantity);
                return;
            }
        }
    }

    public void removeProduct(int productCode) {
        for (int i = 0 ; i < cart.size() ; i++) {
            if (cart.get(i).getProduct().getProductCode() == productCode) {
                cart.remove(i);
                return;
            }
        }
    }

    public double checkout() {
        double sum = 0;
        for(int i = 0 ; i < cart.size() ; i++) {
            sum += cart.get(i).calculateAmount();
        }
        return sum;
    }
}
