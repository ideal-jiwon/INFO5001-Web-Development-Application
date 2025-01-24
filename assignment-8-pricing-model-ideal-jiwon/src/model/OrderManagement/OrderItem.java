/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import model.CustomerManagement.CustomerProfile;
import model.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class OrderItem {

    private Product selectedProduct;
    private float actualPrice;
    private float quantity;
    private Order order; // Reference to the parent Order

    public OrderItem(Product p, float actualPrice, float q) {
        selectedProduct = p;
        quantity = q;
        this.actualPrice = actualPrice;
        p.addOrderItem(this); // Make sure the product links back to this order item
    }
    public CustomerProfile getCustomer() {
    return order.getCustomer(); // Assuming `order` has a reference to the owning Order
}

    public float getOrderItemTotal() {
        return actualPrice * quantity;
    }

    public float getOrderItemTargetTotal() {
        return selectedProduct.getTargetPrice() * quantity;
    }

    public float calculatePricePerformance() {
        return (actualPrice - selectedProduct.getTargetPrice()) * quantity;
    }

    public boolean isActualAboveTarget() {
        return actualPrice > selectedProduct.getTargetPrice();
    }

    public boolean isActualBelowTarget() {
        return actualPrice < selectedProduct.getTargetPrice();
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public float getActualPrice() {
        return actualPrice;
    }

    public float getQuantity() {
        return quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    public void processOrderItem() {
        if (selectedProduct != null) {
            selectedProduct.updateSalesVolume(quantity);
        }
    }
}
