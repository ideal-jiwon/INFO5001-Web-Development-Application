/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.CustomerManagement.*;
import model.OrderManagement.OrderItem;
import model.Supplier.*;

/**
 *
 * @author kal bugrara
 */
public class Product {
    private String name;
    private float floorPrice;
    private float ceilingPrice;
    private float targetPrice;
    private float salesVolume; // Total Sales Quantity
    ArrayList<OrderItem> orderitems;
    private Supplier supplier;
    private Set<CustomerProfile> customers;
    

        public Product( String n, float fp, float cp, float tp) {
        name = n;    
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        salesVolume = 0;
        orderitems = new ArrayList<>();
        this.supplier = supplier;
        this.customers = new HashSet<>();
        
    }
        public Product updateProduct(float fp, float cp, float tp) {
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        return this; //returns itself
    }
    

    public List<OrderItem> getOrderItems() {
        return orderitems;
    }
    public float getTargetPrice() {return targetPrice;}
    public void addOrderItem(OrderItem oi){     
        orderitems.add(oi);
    }
    //Number of item sales above target 
    public float getNumberOfProductSalesAboveTarget(){
        float sum = 0;
        for (OrderItem oi: orderitems){
            if(oi.isActualAboveTarget()==true) sum = sum +1;
        }
        return sum;
    }
    public float getNumberOfProductSalesBelowTarget(){
        float sum = 0;
        for (OrderItem oi: orderitems){
            if(oi.isActualBelowTarget()==true) sum = sum +1;
        }
        return sum;
    }    
    
        public boolean isProductAlwaysAboveTarget(){
        
        for (OrderItem oi: orderitems){
            if(oi.isActualAboveTarget()==false) return false; //
        }
        return true;
    }
    //calculates the revenues gained or lost (in relation to the target)
    //For example, if target is at $2000 and actual is $2500 then revenue gained
    // is $500 above the expected target. If the actual is $1800 then the lose will be $200
    // Add all these difference to get the total including wins and loses
    
        public float getOrderPricePerformance() {
        float sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }

        public float getSalesVolume() {
            return salesVolume;
        //float sum = 0;
        //for (OrderItem oi : orderitems) {
        //    sum = sum + oi.getOrderItemTotal();     //positive and negative values       
        }
        //return sum;
        public void updateSalesVolume(double quantitySold) {
            this.salesVolume += quantitySold;
        }
    
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
    @Override
    public String toString(){
        return name;
    }
    public float getFloorPrice(){
        return floorPrice;
    }
    public float getCeilingPrice(){
        return ceilingPrice;
    }
    public void addSales(float sales) {
        this.salesVolume += sales;
    }
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    // Add a customer to the product
    public void addCustomer(CustomerProfile customer) {
         customers.add(customer);
}

    // Get the customers who purchased the product
    public Set<CustomerProfile> getCustomers() {
         return customers;
}
}

    


