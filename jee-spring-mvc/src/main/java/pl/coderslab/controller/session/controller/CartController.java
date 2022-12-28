package pl.coderslab.controller.session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.controller.session.Cart;
import pl.coderslab.controller.session.CartItem;
import pl.coderslab.controller.session.Product;

import java.util.Random;

@Controller
public class CartController {
    private Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addToCart")
    @ResponseBody
    public String addToCart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), 25.00)));
        return "addToCart";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String printCart() {
        return cart.toString();
    }
}
