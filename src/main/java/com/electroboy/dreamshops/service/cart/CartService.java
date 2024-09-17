package com.electroboy.dreamshops.service.cart;

import com.electroboy.dreamshops.dto.CartDto;
import com.electroboy.dreamshops.exceptions.ResourceNotFoundException;
import com.electroboy.dreamshops.model.Cart;
import com.electroboy.dreamshops.model.User;
import com.electroboy.dreamshops.repository.CartItemRepository;
import com.electroboy.dreamshops.repository.CartRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService{
  private final CartRepository cartRepository;
  private final CartItemRepository cartItemRepository;
  private final ModelMapper modelMapper;

  @Override
  public Cart getCart(Long id) {
    Cart cart = cartRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));
    BigDecimal totalAmount = cart.getTotalAmount();
    cart.setTotalAmount(totalAmount);
    return cartRepository.save(cart);
  }

  @Transactional
  @Override
  public void clearCart(Long id) {
    Cart cart = getCart(id);
    cartItemRepository.deleteAllByCartId(id);
    cart.clearCart();
    cartRepository.deleteById(id);
  }

  @Override
  public BigDecimal getTotalPrice(Long id) {
    Cart cart = getCart(id);
    return cart.getTotalAmount();
  }

  @Override
  public Cart initializeNewCart(User user) {
    return Optional.ofNullable(getCartByUserId(user.getId()))
            .orElseGet(() -> {
              Cart cart = new Cart();
              cart.setUser(user);
              return cartRepository.save(cart);
            });
  }

  @Override
  public Cart getCartByUserId(Long userId) {
    return cartRepository.findByUserId(userId);
  }

  @Override
  public CartDto convertCartToDto(Cart cart) {
    return modelMapper.map(cart, CartDto.class);
  }
}
