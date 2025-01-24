/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;
import java.util.List;
import model.MarketModel.Market;
import model.OrderManagement.Order;
import model.Personnel.Person;

public class CustomerProfile {
    private List<Order> orders; // Changed to private for encapsulation
    private List<Market> markets; // Changed to private for encapsulation
    private Person person;

    // Constructor to initialize the customer profile
    public CustomerProfile(Person p) {
        this.person = p;
        this.orders = new ArrayList<>();
        this.markets = new ArrayList<>();
    }

    // Add an order to the customer's order list
    public void addCustomerOrder(Order order) {
        orders.add(order);
        order.processOrder();
    }

    // Return all orders for the customer
    public List<Order> getOrders() {
        return orders;
    }
    public static CustomerProfile findTopSpendingCustomer(List<CustomerProfile> customers) {
        CustomerProfile topCustomer = null;
        float maxSpent = 0;
    
        for (CustomerProfile customer : customers) {
            float totalSpent = 0;
    
            for (Order order : customer.getOrders()) {
                totalSpent += order.getOrderTotal(); // Assuming `getOrderTotal()` calculates total for an order
            }
    
            if (totalSpent > maxSpent) {
                maxSpent = totalSpent;
                topCustomer = customer;
            }
        }
        return topCustomer;
    }
    
    
    // Calculate the total price performance for all orders
    public int getTotalPricePerformance() {
        int totalPerformance = 0;
        for (Order order : orders) {
            totalPerformance += order.getOrderPricePerformance();
        }
        return totalPerformance;
    }

    // Get the number of orders above the total target
    public int getNumberOfOrdersAboveTotalTarget() {
        int count = 0;
        for (Order order : orders) {
            if (order.isOrderAboveTotalTarget()) {
                count++;
            }
        }
        return count;
    }

    // Get the number of orders below the total target
    public int getNumberOfOrdersBelowTotalTarget() {
        int count = 0;
        for (Order order : orders) {
            if (!order.isOrderAboveTotalTarget()) {
                count++;
            }
        }
        return count;
    }

    // Check if the customer's ID matches the given ID
    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    // Get the customer's ID
    public String getCustomerId() {
        return person.getPersonId();
    }

    // Get the Person object for this customer
    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Customer ID: " + person.getPersonId();
    }
}
