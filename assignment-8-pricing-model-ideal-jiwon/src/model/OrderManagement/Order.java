/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import java.util.ArrayList;
import java.util.List;
import model.CustomerManagement.CustomerProfile;
import model.MarketModel.MarketChannelAssignment;
import model.ProductManagement.Product;
import model.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class Order {

    ArrayList<OrderItem> orderitems;
    CustomerProfile customer;
    SalesPersonProfile salesperson;
    MarketChannelAssignment mca;
    String status;

    public Order(){
        orderitems = new ArrayList<>();
        status = "in process";
    }
    
    public Order(CustomerProfile cp) {
        this();
        customer = cp;
        customer.addCustomerOrder(this); //we link the order to the customer
        salesperson = null;
    }


    public Order(CustomerProfile cp, SalesPersonProfile ep) {
        orderitems = new ArrayList<>();
        customer = cp;
        salesperson = ep;
        customer.addCustomerOrder(this); //we link the order to the customer
        salesperson.addSalesOrder(this);  
    }
    public OrderItem newOrderItem(Product p, float actualprice, float q) {
        OrderItem oi = new OrderItem(p, actualprice, q);
        orderitems.add(oi);
        p.addSales(q);
        return oi;
    }
    //order total is the sumer of the order item totals
    public float getOrderTotal() {
        float sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    }

    public float getOrderPricePerformance() {
        float sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }

    public float getNumberOfOrderItemsAboveTarget() {
        float sum = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }
    
    //sum all the item targets and compare to the total of the order 
    public boolean isOrderAboveTotalTarget(){
        float sum = 0;
        for (OrderItem oi: orderitems){
            sum = sum + oi.getOrderItemTargetTotal(); //product targets are added
        }
        if(getOrderTotal()>sum) {return true;}
        else {return false;}
        
    }
    public void processOrder() {
        for (OrderItem item : orderitems) {
            item.processOrderItem();
        }
    }
public void CancelOrder(){
    status = "Cancelled";
}
public void Submit(){
    status = "Submitted";
}

public OrderItem[] OrderItem() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'OrderItem'");
}
public CustomerProfile getCustomer() {
    return customer;
}
public List<OrderItem> getOrderItems(){
    return orderitems;
}
public String getStatus(){
    return status;
}
}
