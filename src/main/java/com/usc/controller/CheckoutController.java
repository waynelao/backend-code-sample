package com.usc.controller;

import com.usc.dto.PurchaseDTO;
import com.usc.dto.PurchaseResponseDTO;
import com.usc.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    CheckoutService checkoutService;

    @PostMapping("/purchase")
    public PurchaseResponseDTO placeOrder(@RequestBody PurchaseDTO purchaseDTO, Authentication authentication) {

        PurchaseResponseDTO purchaseResponseDTO = checkoutService.placeOrder(purchaseDTO, authentication);

        return purchaseResponseDTO;

    }
}
