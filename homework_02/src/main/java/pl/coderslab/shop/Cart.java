package pl.coderslab.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private final static Logger logger = LoggerFactory.getLogger(Cart.class);
    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addToCart(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public int totalQuantity() {
        return cartItems.stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    public double totalAmount() {
        return cartItems.stream()
                .mapToDouble(CartItem::itemAmount)
                .sum();
    }

    public boolean hasProductWithId(long id) {
        return cartItems.stream()
                .map(CartItem::getProduct)
                .anyMatch(p -> p.getId() == id);
    }

    public long getQuantityById(long id) {
        int quantity = -1;
        for (CartItem c : cartItems
          ) {
            if (c.getProduct().getId() == id) {
                quantity = c.getQuantity();
            }
        }
        return quantity;
        }

    public void updateQuantity(long id, int quantity) {
        cartItems.stream()
                .filter(c -> c.getProduct().getId() == id)
                .findFirst()
                .ifPresent(cartItem -> cartItem.setQuantity(cartItem.getQuantity() + quantity));
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItems=" + cartItems +
                '}';
    }
}