package com.usc.dto;

public class PurchaseResponseDTO {
    private String orderTrackingNumber;

    public PurchaseResponseDTO() {
    }

    public PurchaseResponseDTO(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }

    public String getOrderTrackingNumber() {
        return orderTrackingNumber;
    }

    public void setOrderTrackingNumber(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}
