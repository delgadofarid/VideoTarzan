package com.store.videotarzan.controller;

import com.store.videotarzan.model.Cart;
import com.store.videotarzan.model.CartItem;
import com.store.videotarzan.model.Customer;
import com.store.videotarzan.model.Movie;
import com.store.videotarzan.service.CartItemService;
import com.store.videotarzan.service.CartService;
import com.store.videotarzan.service.CustomerService;
import com.store.videotarzan.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MovieService movieService;

    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart getCartById (@PathVariable(value = "cartId") Long cartId) {
        return cartService.getCartById(cartId);
    }

    @RequestMapping(value = "/add/{movieId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value = "movieId") Long movieId, @AuthenticationPrincipal User activeUser) {
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Movie movie = movieService.getMovieById(movieId);
        List<CartItem> cartItems = cart.getCartItems();
        for (int i = 0; i < cartItems.size(); i++) {
            if (movie.getMovieId().longValue() == cartItems.get(i).getMovie().getMovieId().longValue()) {
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(movie.getMoviePrice() * cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);
                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setMovie(movie);
        cartItem.setQuantity(1);
        cartItem.setCart(cart);
        cartItem.setTotalPrice(movie.getMoviePrice() * cartItem.getQuantity());
        cartItemService.addCartItem(cartItem);
    }

    @RequestMapping(value = "remove/{movieId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "movieId") Long movieId) {
        CartItem cartItem = cartItemService.getCartItemByMovieId(movieId);
        cartItemService.removeCartItem(cartItem);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartId") Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientError (Exception e) {
        e.printStackTrace();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerError (Exception e) {
        e.printStackTrace();
    }


}
