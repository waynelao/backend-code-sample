package com.usc.service;

import com.usc.dto.PurchaseDTO;
import com.usc.dto.PurchaseResponseDTO;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public interface CheckoutService {
    PurchaseResponseDTO placeOrder(PurchaseDTO purchaseDTO, Authentication authentication);

}
