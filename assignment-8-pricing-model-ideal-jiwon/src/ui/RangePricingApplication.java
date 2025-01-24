/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import model.Business.Business;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.OrderManagement.Order;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;

/**
 *
 * @author kal bugrara
 */
public class RangePricingApplication {

    public static void main(String[] args) {
        // PART 01- a : Initialize business
        Business business = new Business("DashingDiva");

        // PART 01 -b : Load 30 suppliers from a CSV file into Business
        String supplierFilePath = "/workspaces/assignment-8-pricing-model-ideal-jiwon/CSV/Suppliers_DD.csv";
        SupplierDirectory supplierDirectory = new SupplierDirectory();
        supplierDirectory.SuppliersFromCSV(supplierFilePath);
        List<Supplier> allSuppliers = supplierDirectory.getSupplierList();
        // PART 01 - b add all suppliers to the initialized business 
        business.getSupplierDirectory().setSupplierList(allSuppliers);

        // PART 01 - c : Picky any 10 suppliers and add 20 products to each
        // Part 01 - c  : Load products from a CSV file
        String productFilePath = "/workspaces/assignment-8-pricing-model-ideal-jiwon/CSV/Product_Catalog_DD.csv";
        ProductCatalog productCatalog = new ProductCatalog("GeneralCatalog");
        productCatalog.loadProductsFromCSV(productFilePath, allSuppliers);
        List<Product> allProducts = productCatalog.getProductList();

        // Select 10 random suppliers
        List<Supplier> selectedSuppliers = new ArrayList<>();
        Random random = new Random();

        while (selectedSuppliers.size() < 10 && allSuppliers.size() >= 10) {
            Supplier supplier = allSuppliers.get(random.nextInt(allSuppliers.size()));
            if (!selectedSuppliers.contains(supplier)) {
                selectedSuppliers.add(supplier);
            }
        }

        // Assign 20 products to each selected supplier
        for (Supplier supplier : allSuppliers) {
            ProductCatalog supplierCatalog = supplier.getProductCatalog();
            Set<Product> assignedProducts = new HashSet<>();

        // Randomly assign 20 products
        while (assignedProducts.size() < 20) {
            Product randomProduct = allProducts.get(random.nextInt(allProducts.size()));
            assignedProducts.add(randomProduct);
    }

    for (Product product : assignedProducts) {
        supplierCatalog.newProduct(product.getName(), product.getFloorPrice(), product.getCeilingPrice(), product.getTargetPrice(),supplier);
    }
}
           // Part 1 - d. Load 50 customers from a CSV file
           String customerFilePath = "/workspaces/assignment-8-pricing-model-ideal-jiwon/CSV/Customer_DD.csv";
           CustomerDirectory customerDirectory = new CustomerDirectory(business);
           customerDirectory.loadCustomersFromCSV(customerFilePath);
           List<CustomerProfile> allCustomers = customerDirectory.getCustomerlist();

        // PART 01 - e : Assign 1-3 orders to 25 randomly picked customers
        List<CustomerProfile> selectedCustomers = new ArrayList<>();
        Set<CustomerProfile> uniqueCustomers = new HashSet<>();

        while (uniqueCustomers.size() < 25) {
            CustomerProfile randomCustomer = allCustomers.get(random.nextInt(allCustomers.size()));
            uniqueCustomers.add(randomCustomer);
        }
        selectedCustomers.addAll(uniqueCustomers);

        for (CustomerProfile customer : selectedCustomers) {
            int numberOfOrders = random.nextInt(3) + 1; // 1-3 orders

            for (int i = 0; i < numberOfOrders; i++) {
                Order order = new Order(customer);

                int numberOfItems = random.nextInt(10) + 1; // 1-10 items
                for (int j = 0; j < numberOfItems; j++) {
                    Product randomProduct = allProducts.get(random.nextInt(allProducts.size()));
                    float randomPrice = randomProduct.getTargetPrice();
                    float randomQuantity = random.nextInt(10) + 1; // Random quantity between 1-10
                    order.newOrderItem(randomProduct, randomPrice, randomQuantity);
                }
                customer.addCustomerOrder(order);
            }
        }
        System.out.println("PART02-----------------------------");
        // 1. Pick three random Customers and print out their Sales orders
        // Pick 3 random customers and print their sales order
        Set<CustomerProfile> threeRandomCustomers = new HashSet<>();
        while (threeRandomCustomers.size() < 3) {
            threeRandomCustomers.add(selectedCustomers.get(random.nextInt(selectedCustomers.size())));
}        // Print customers and their orders
        for (CustomerProfile customer : threeRandomCustomers) {
            System.out.println(customer);

        List<Order> orders = customer.getOrders();
            for (Order order : orders) {
                    System.out.printf("  Order Total: %.2f%n", order.getOrderTotal());
         }
      }
         System.out.println("----------------------------------------");

        // 2. Pick three random Suppliers and find their most expensive products
        System.out.println("Three Suppliers and their most Expensive Products:");
        for (int i = 0; i < 3; i++) {
            Supplier supplier = allSuppliers.get(random.nextInt(allSuppliers.size()));
            System.out.println("Supplier: " + supplier.getName());

            List<Product> products = supplier.getProductCatalog().getProductList();

            Product mostExpensiveProduct = Collections.max(products, Comparator.comparing(Product::getCeilingPrice));
            System.out.println("-- Most Expensive Product: " + mostExpensiveProduct.getName()
                + " -- Ceiling Price: " + mostExpensiveProduct.getCeilingPrice());
        }

        // 3. Find a customer who spent the most money with us
        CustomerProfile topCustomer = allCustomers.stream()
            .max(Comparator.comparingDouble(customer -> customer.getOrders()
                .stream()
                .mapToDouble(Order::getOrderTotal)
                .sum()))
            .orElse(null);

        if (topCustomer != null) {
            System.out.println("Customer Who Spent the Most Money:");
            System.out.println("Customer ID: " + topCustomer.getCustomerId());
            System.out.println("Total Spent: " + topCustomer.getOrders()
                .stream()
                .mapToDouble(Order::getOrderTotal)
                .sum());
        } 

        // 4. Find a Supplier with the most sales
        Supplier topSupplier = allSuppliers.stream()
            .max(Comparator.comparingDouble(supplier -> supplier.getProductCatalog().getProductList()
                .stream()
                .mapToDouble(Product::getSalesVolume)
                .sum()))
            .orElse(null);

        if (topSupplier != null) {
            System.out.println("Supplier with Most Sales:");
            System.out.println("Supplier: " + topSupplier.getName());
            System.out.println("Total Sales: " + topSupplier.getProductCatalog().getProductList()
                .stream()
                .mapToDouble(Product::getSalesVolume)
                .sum());
        } 

        // 5. Find a Supplier with the least sales (non-zero)
        Supplier leastSupplier = allSuppliers.stream()
            .filter(supplier -> supplier.getProductCatalog().getProductList()
                .stream()
                .mapToDouble(Product::getSalesVolume)
                .sum() > 0)
            .min(Comparator.comparingDouble(supplier -> supplier.getProductCatalog().getProductList()
                .stream()
                .mapToDouble(Product::getSalesVolume)
                .sum()))
            .orElse(null);

        if (leastSupplier != null) {
            System.out.println("Supplier with Least Sales (Non-Zero):");
            System.out.println("Supplier: " + leastSupplier.getName());
            System.out.println("Total Sales: " + leastSupplier.getProductCatalog().getProductList()
                .stream()
                .mapToDouble(Product::getSalesVolume)
                .sum());
        }

        // Part 03 - Suppliers Report
        // 1. Assign 20 products to each suppliers (30)
        Random randomReport = new Random();
        for (Supplier supplier : allSuppliers) {
            ProductCatalog supplierCatalog = supplier.getProductCatalog();
            Set<Product> assignedProducts = new HashSet<>();

        // Randomly assign 20 products to each supplier
            while (assignedProducts.size() < 20) {
        Product randomProduct = allProducts.get(randomReport.nextInt(allProducts.size()));
        assignedProducts.add(randomProduct);
    }

    for (Product product : assignedProducts) {
        supplierCatalog.newProduct(product.getName(), product.getFloorPrice(), product.getCeilingPrice(), product.getTargetPrice(),supplier);
    }
}

    // Generate new random orders for all customers (50) for the report
        for (CustomerProfile customer : allCustomers) {
         int numOrders = randomReport.nextInt(3) + 1; // 1-3 orders per customer
         for (int i = 0; i < numOrders; i++) {
                Order order = new Order(customer);
                int numItems = randomReport.nextInt(10) + 1; // 1-10 items per order
                for (int j = 0; j < numItems; j++) {
                    Product randomProduct = allProducts.get(randomReport.nextInt(allProducts.size()));
                    float randomPrice = randomProduct.getTargetPrice();
                    float randomQuantity = randomReport.nextInt(10) + 1; // Random quantity between 1-10
                    order.newOrderItem(randomProduct, randomPrice, randomQuantity);
        }
        customer.addCustomerOrder(order);
    }
}

    // Generate and print the Supplier Sales Report
    generateSupplierSalesReport(allSuppliers);
    }
    private static void generateSupplierSalesReport(List<Supplier> suppliers) {
        // Header for the report
        System.out.printf("%-5s %-20s %-15s %-20s %-10s\n", "Rank", "Supplier", "Total Sales", "Top Product", "Customers");
        System.out.println("----------------------------------------------------------------------");

        // Create a list for report entries
        List<SupplierReportEntry> reportEntries = new ArrayList<>();

        for (Supplier supplier : suppliers) {
            SupplierReportEntry entry = new SupplierReportEntry();
            entry.supplier = supplier;

            float totalSales = 0;
            Product topProduct = null;
            float highestSales = 0;

            // Calculate sales and find the top product
            List<Product> products = supplier.getProductCatalog().getProductList();
            Set<String> uniqueCustomers = new HashSet<>();

            for (Product product : products) {
                float productSales = product.getSalesVolume();
                totalSales += productSales;

                if (productSales > highestSales) {
                    highestSales = productSales;
                    topProduct = product;
                }

                // Collect unique customers who ordered this product
                product.getOrderItems().forEach(orderItem -> {
                    uniqueCustomers.add(orderItem.getOrder().getCustomer().getCustomerId());
                });
            }

            entry.totalSales = totalSales;
            entry.topProduct = topProduct;
            entry.numberOfDifferentCustomers = uniqueCustomers.size();

            reportEntries.add(entry);
        }

        // Sort the report by total sales descending
        reportEntries.sort(Comparator.comparingDouble((SupplierReportEntry e) -> e.totalSales).reversed());

        // Assign ranks and print
        int rank = 1;
        for (SupplierReportEntry entry : reportEntries) {
            entry.rank = rank++;
            System.out.printf("%-5d %-20s %-15.2f %-20s %-10d\n",
                    entry.rank,
                    entry.supplier.getName(),
                    entry.totalSales,
                    entry.topProduct != null ? entry.topProduct.getName() : "None",
                    entry.numberOfDifferentCustomers);
        }
    }

    // Inner class for the report entry
    private static class SupplierReportEntry {
        int rank;
        Supplier supplier;
        float totalSales;
        Product topProduct;
        int numberOfDifferentCustomers;
    }
}
    
