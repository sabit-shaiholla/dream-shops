package com.electroboy.dreamshops.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.electroboy.dreamshops.dto.CartDto;
import com.electroboy.dreamshops.exceptions.ResourceNotFoundException;
import com.electroboy.dreamshops.model.Cart;
import com.electroboy.dreamshops.response.ApiResponse;
import com.electroboy.dreamshops.service.cart.ICartService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/carts")
public class CartController {
  private final ICartService cartService;

  @GetMapping("/{cartId}/my-cart")
  public ResponseEntity<ApiResponse> getCart(@PathVariable Long cartId) {
    try {
      Cart cart = cartService.getCart(cartId);
      CartDto cartDto = cartService.convertCartToDto(cart);
      return ResponseEntity.ok(new ApiResponse("Success", cartDto));
    } catch (ResourceNotFoundException e) {
      return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
    }
  }

  @DeleteMapping("/{cartId}/clear")
  public ResponseEntity<ApiResponse> clearCart(@PathVariable Long cartId) {
    try {
      cartService.clearCart(cartId);
      return ResponseEntity.ok(new ApiResponse("Clear Cart Success!", null));
    } catch (ResourceNotFoundException e) {
      return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
    }
  }

  @GetMapping("/{cartId}/cart/total-price")
  public ResponseEntity<ApiResponse> getTotalAmount(@PathVariable Long cartId) {
    try {
      BigDecimal totalPrice = cartService.getTotalPrice(cartId);
      return ResponseEntity.ok(new ApiResponse("Total Price", totalPrice));
    } catch (ResourceNotFoundException e) {
      return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
    }
  }
}
