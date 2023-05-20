package com.usc.service;

import com.usc.beans.OrderItem;
import com.usc.beans.User;
import com.usc.dao.CustomerDao;
import com.usc.dao.UserDao;
import com.usc.dto.PurchaseDTO;
import com.usc.dto.PurchaseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.usc.beans.Order;
import com.usc.beans.Customer;

import javax.transaction.Transactional;
import java.util.UUID;
import java.util.Set;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    @Autowired
    CustomerDao customerDao;

    @Autowired
    UserDao userDao;

    @Override
    @Transactional
    public PurchaseResponseDTO placeOrder(PurchaseDTO purchaseDTO, Authentication authentication) {
        // retrieve the order info from dto
        Order order = purchaseDTO.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // populate order with user
        order.setUser(userDao.findByUsername(authentication.getName()));

        //populate order with orderItems
        Set<OrderItem> orderItems = purchaseDTO.getOrderItems();
        orderItems.forEach(item -> order.add(item));


        // populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchaseDTO.getBillingAddress());
        order.setShippingAddress(purchaseDTO.getShippingAddress());

        // populate customer with order
        Customer customer = purchaseDTO.getCustomer();
        customer.add(order);


        // save to the database
        customerDao.save(customer);

        // return a response
        return new PurchaseResponseDTO(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)
        return UUID.randomUUID().toString();
    }

}
