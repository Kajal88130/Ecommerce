package com.ecom.services.customer.wishlist;

import com.ecom.dto.UserDto;
import com.ecom.dto.WishlistDto;
import com.ecom.entity.Product;
import com.ecom.entity.Wishlist;
import com.ecom.repository.ProductRepository;
import com.ecom.repository.WishlistRepository;
import com.ecom.services.feign.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService{

    private final ProductRepository productRepository;

    private final WishlistRepository wishlistRepository;

    private final AuthService authService;


    public WishlistDto addProductToWishlist(WishlistDto wishlistDto){
        Optional<Product> optionalProduct = productRepository.findById(wishlistDto.getProductId());
        ResponseEntity<UserDto> userDto = authService.getUserById(wishlistDto.getUserId());
        if(optionalProduct.isPresent() && userDto.getStatusCode().is2xxSuccessful()){
            Wishlist wishlist = new Wishlist();
            wishlist.setProduct(optionalProduct.get());
            wishlist.setUserId(Objects.requireNonNull(userDto.getBody()).getId());

            return wishlistRepository.save(wishlist).getWishlistDto();
        }
        return null;
    }

    public List<WishlistDto> getWishlistByUserId(Long userId){
        return wishlistRepository.findAllByUserId(userId).stream().map(Wishlist::getWishlistDto).collect(Collectors.toList());
    }
}
