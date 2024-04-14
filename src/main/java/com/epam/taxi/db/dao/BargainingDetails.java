/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.epam.taxi.db.dao;

public class BargainingDetails {
    private int orderId;
    private double proposedFare;
    private String status;

    // Constructor, getters, and setters

    public BargainingDetails(int orderId, double proposedFare, String status) {
        this.orderId = orderId;
        this.proposedFare = proposedFare;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getProposedFare() {
        return proposedFare;
    }

    public void setProposedFare(double proposedFare) {
        this.proposedFare = proposedFare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Add a method to check if the proposed fare is valid
    public boolean isProposedFareValid(double originalPrice) {
        return proposedFare >= originalPrice;
    }
    
}
