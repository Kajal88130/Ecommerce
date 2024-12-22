package com.ecom.controller;

import com.ecom.dto.OrderDto;
import com.ecom.dto.TrackingDto;
import com.ecom.services.customer.cart.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TrackingController {

    private final CartService cartService;

    @PostMapping("/order/tracking")
    public ResponseEntity<OrderDto> searchOrderByTrackingId(@RequestBody TrackingDto trackingDto) {
        OrderDto orderDto = cartService.searchOrderByTrackingId(trackingDto.getTrackingId());
        if (orderDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(orderDto);
    }
}
