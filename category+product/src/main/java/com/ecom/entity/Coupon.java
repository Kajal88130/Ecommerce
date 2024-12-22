package com.ecom.entity;

import com.ecom.dto.CouponDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String code;

    private Long discount;

    private Date expirationDate;

    public CouponDto getCouponDto() {
        CouponDto couponDto = new CouponDto();
        couponDto.setId(id);
        couponDto.setCode(code);
        couponDto.setDiscount(discount);
        couponDto.setExpirationDate(expirationDate);
        couponDto.setName(name);
        return couponDto;
    }

}
