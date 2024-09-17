package com.electroboy.dreamshops.service.cart;

import com.electroboy.dreamshops.dto.CartDto;
import com.electroboy.dreamshops.model.Cart;
import com.electroboy.dreamshops.model.User;

import java.math.BigDecimal;

public interface ICartService {
  Cart getCart(Long id);
  void clearCart(Long id);
  BigDecimal getTotalPrice(Long id);
  Cart initializeNewCart(User user);
  Cart getCartByUserId(Long userId);
  CartDto convertCartToDto(Cart cart);
}
