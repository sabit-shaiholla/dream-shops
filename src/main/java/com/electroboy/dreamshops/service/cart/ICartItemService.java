package com.electroboy.dreamshops.service.cart;

import com.electroboy.dreamshops.model.Cart;
import com.electroboy.dreamshops.model.CartItem;
import java.math.BigDecimal;

public interface ICartItemService {
  void addItemToCart(Long cartId, Long productId, int quantity);
  void removeItemFromCart(Long cartId, Long productId);
  void updateItemQuantity(Long cartId, Long productId, int quantity);
  CartItem getCartItem(Long cartId, Long productId);
}
