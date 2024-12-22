package com.ecom.entity;

import com.ecom.dto.CartItemsDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    private Long quantity;

    private Long productId;

    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

//    public CartItemsDto getCartDto() {
//        CartItemsDto cartItemsDto = new CartItemsDto();
//        cartItemsDto.setId(id);
//        cartItemsDto.setPrice(price);
//        cartItemsDto.setProductId(productId);
//        cartItemsDto.setQuantity(quantity);
//        cartItemsDto.setUserId(userId);
////        cartItemsDto.setProductName(product.getName());
////        cartItemsDto.setReturnedImg(product.getImg());
//        return cartItemsDto;
//    }
}
