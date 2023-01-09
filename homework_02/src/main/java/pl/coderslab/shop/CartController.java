package pl.coderslab.shop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class CartController {

    private final static Logger logger = LoggerFactory.getLogger(CartController.class);

    private Cart cart;
    private ProductDao productDao;

    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

/*    @RequestMapping("/addtocart")
    @ResponseBody
    public String addToCart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }*/

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("id") long id, @RequestParam("quantity") int quantity) {
        logger.debug("running add to cart with given params, id: {}, quantity: {}", id, quantity);
        if (cart.hasProductWithId(id)) {
            logger.debug("there is already product with given id, updating");
            cart.updateQuantity(id, quantity);
            return "quantityUpdated";
        }
        Product product = productDao.getProductById(id);
        CartItem cartItem = new CartItem(quantity, product);
        logger.debug("This is new product in cart, adding new cart item: {}", cartItem);
        cart.addToCart(cartItem);
        return "addToCart";
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        int cartSize = cart.getCartItems().size();
        int totalQnt = cart.totalQuantity();
        double amountToPay = cart.totalAmount();
        List<CartItem> cartItemList = cart.getCartItems();

        model.addAttribute("cartSize", cartSize);
        model.addAttribute("totalQnt", totalQnt);
        model.addAttribute("amountToPay", amountToPay);
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("id_1_qnt", getQuantityById(1));
        model.addAttribute("id_2_qnt", getQuantityById(2));
        model.addAttribute("id_3_qnt", getQuantityById(3));
        return "cart";
    }

    @GetMapping("/getQuantityById/{id}")
    @ResponseBody
    public String getQuantityById(@PathVariable long id) {
        long qnt = cart.getQuantityById(id);
        String value = String.valueOf(qnt);
        return value;
    }

    @GetMapping("/addOne")
    public String addOne(@RequestParam long id) {
        cart.updateQuantity(id, 1);
        return "addToCart";
    }

    @GetMapping("/removeOne")
    public String removeOne(@RequestParam long id) {
        cart.updateQuantity(id, -1);
        return "addToCart";
    }
}