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


public class DebugTest {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PINK = "\u001B[95m";
    public static final String PURPLE = "\u001B[35m";
    public static final String LAVENDER = "\u001B[94m";

    public static void main(String[] args) {
        // PART 01- a : Initialize business
        System.out.println(RED + " Part01 - Populating one business model----------");
        Business business = new Business(RED + "DashingDiva");
        System.out.println(); // space


        /// PART 01 -b : Load 30 suppliers from a CSV file into Business
        System.out.println(YELLOW + " Part01 - Populating 30 Suppliers----------");
        String supplierFilePath = "/workspaces/assignment-8-pricing-model-ideal-jiwon/CSV/Suppliers_DD.csv";
        SupplierDirectory supplierDirectory = new SupplierDirectory();
        System.out.println(YELLOW + "Debug: Reading suppliers from CSV file: " + supplierFilePath); // Debug
        supplierDirectory.SuppliersFromCSV(supplierFilePath);
        System.out.println(YELLOW + "Debug: Retrieving all suppliers"); // Debug
        List<Supplier> allSuppliers = supplierDirectory.getSupplierList();
        System.out.println(YELLOW + "Debug: Total suppliers loaded: " + allSuppliers.size());
        // PART 01 - b add all suppliers to the initialized business 
        business.getSupplierDirectory().setSupplierList(allSuppliers);
        System.out.println(); // spacec


        // PART 01 - c : Picky any 10 suppliers and add 20 products to each
        // Part 01 - c  : Load products from a CSV file
        System.out.println(BLUE + " Part01 - Populating 30 Suppliers----------");
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
            supplierCatalog.newProduct(product.getName(), product.getFloorPrice(), product.getCeilingPrice(), product.getTargetPrice(), supplier);
    }
       // Debug Code to show if 10 suppliers were randomly picked and 20 products have been added for each
       System.out.println(BLUE + " Part01 - Populating 10 Suppliers with 20 products assigned to each supplier ----------");
        System.out.println(BLUE + "\nSupplier: " + supplier.getName() + " - Assigned Products:");
        for (Product product : assignedProducts) {
            supplierCatalog.newProduct(product.getName(), product.getFloorPrice(), product.getCeilingPrice(), product.getTargetPrice(),supplier);
            System.out.println(BLUE +"    Product: " + product.getName() 
                               + " | Floor Price: " + product.getFloorPrice() 
                               + " | Ceiling Price: " + product.getCeilingPrice() 
                               + " | Target Price: " + product.getTargetPrice());
    }
        System.out.println(); // space
}
    
         // Part 1 - d. Load 50 customers from a CSV file
         System.out.println(GREEN + "\nPart01 - Populating 50 Cusotmers----------");
         String customerFilePath = "/workspaces/assignment-8-pricing-model-ideal-jiwon/CSV/Customer_DD.csv";
         CustomerDirectory customerDirectory = new CustomerDirectory(business);
         customerDirectory.loadCustomersFromCSV(customerFilePath);
         System.out.println(GREEN + "Debug: Retrieving all customers"); // Debug
         List<CustomerProfile> allCustomers = customerDirectory.getCustomerlist();
         System.out.println(GREEN + "Debug: Total suppliers loaded: " + allCustomers.size());
         System.out.println(); // space
        
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
            System.out.println("\nCustomer: " + customer.getCustomerId() + " - Assigning " + numberOfOrders + " orders");

            for (int i = 0; i < numberOfOrders; i++) {
                Order order = new Order(customer);
                int numberOfItems = random.nextInt(10) + 1; // 1-10 items
                //Debugging codes 
                System.out.println("  Order " + (i + 1) + ": Assigning " + numberOfItems + " items");

                for (int j = 0; j < numberOfItems; j++) {
                    Product randomProduct = allProducts.get(random.nextInt(allProducts.size()));
                    float randomPrice = randomProduct.getTargetPrice();
                    float randomQuantity = random.nextInt(10) + 1; // Random quantity between 1-10
                    order.newOrderItem(randomProduct, randomPrice, randomQuantity);

                    // Update salesVolume for the product -> it will be used for the part 02 to show the suppliers with the most and least sales
                    randomProduct.addSales(randomQuantity);

                    // Debug: Print each item
                    System.out.println("    Item " + (j + 1) + ": " +
                        "Product: " + randomProduct.getName() +
                        ", Price: " + randomPrice +
                        ", Quantity: " + randomQuantity+
                        ", Updated Sales Volume: " + randomProduct.getSalesVolume());
                }
                customer.addCustomerOrder(order);
                System.out.println();
            }
        }
        System.out.println(RED +"\nPART02-----------------------------");
        // 1. Pick three random Customers and print out their Sales orders
        // Pick 3 random customers and print their sales order
        Set<CustomerProfile> threeRandomCustomers = new HashSet<>();
        while (threeRandomCustomers.size() < 3) {
            threeRandomCustomers.add(selectedCustomers.get(random.nextInt(selectedCustomers.size())));
}        // Print customers and their orders
        System.out.println(RED+"\nDebug: Printing sales orders for 3 random customers:");
        for (CustomerProfile customer : threeRandomCustomers) {
            System.out.println(customer.getCustomerId());

        //List<Order> orders = customer.getOrders();
        //This part changed from List to Set while debugging after duplicate orders are found to be added.
        Set<Order> uniqueOrders = new HashSet<>(customer.getOrders());
            for (Order order : uniqueOrders) {
                    System.out.printf(RED+" Sales Order: %.2f%n", order.getOrderTotal());
         }
         System.out.println("----------------------------------------");    
         System.out.println();    
        }

        // 2. Pick three random Suppliers and find their most expensive products
        System.out.println(GREEN + "PART2 - B : ");
        System.out.println(GREEN + "Three Suppliers and their most Expensive Products:");
        for (int i = 0; i < 3; i++) {
            Supplier supplier = allSuppliers.get(random.nextInt(allSuppliers.size()));
            System.out.println(GREEN+"\nSupplier: " + supplier.getName());

            List<Product> products = supplier.getProductCatalog().getProductList();

            Product mostExpensiveProduct = Collections.max(products, Comparator.comparing(Product::getCeilingPrice));
            System.out.println(GREEN + "  Most Expensive Product: " 
                                     + mostExpensiveProduct.getName()
                                     + "  | Ceiling Price: " + mostExpensiveProduct.getCeilingPrice());  
        }
        System.out.println("----------------------------------------");    
        System.out.println();   
        // 3. Find a customer who spent the most money with us
        System.out.println(YELLOW + "PART02 - C : Find a customer with the highest sales"); 
        CustomerProfile topCustomer = allCustomers.stream()
            .max(Comparator.comparingDouble(customer -> customer.getOrders()
                .stream()
                .mapToDouble(Order::getOrderTotal)
                .sum()))
            .orElse(null);

        if (topCustomer != null) {
            System.out.println(YELLOW + "\nCustomer Who Spent the Most Money:");
            System.out.println(YELLOW + "  | Customer ID: " + topCustomer.getCustomerId());
            System.out.println(YELLOW + "  | Total Spent: " + topCustomer.getOrders()
                .stream()
                .mapToDouble(Order::getOrderTotal)
                .sum());
        } 
        System.out.println("----------------------------------------");    
        System.out.println();   

        // 4. Find a Supplier with the most sales
        System.out.println(LAVENDER + "PART02-D : Find the Supplier with the Most Sales Based on Customer Spending");
        System.out.println("Debug: Product Sales Volume");
        for (Product product : allProducts) {
            System.out.println("Product: " + product.getName() + ", Sales Volume: " + product.getSalesVolume());
        }
        // Assuming `allSuppliers` and `allProducts` are available
for (Supplier supplier : allSuppliers) {
    float totalSalesVolume = 0.0f;

    for (Product product : allProducts) {
        // Check if the product belongs to the supplier's ProductCatalog
        if (supplier.getProductCatalog().getProductList().contains(product)) {
            totalSalesVolume += product.getSalesVolume(); // Accumulate sales volume
        }
    }

    // Update the supplier's total sales (if needed)
    supplier.setTotalSales(totalSalesVolume);

    // Debugging output for verification
    System.out.println("Supplier: " + supplier.getName() +
            ", Total Sales Volume: " + totalSalesVolume);
}

// Find Supplier with Most Sales
Supplier topSupplier = allSuppliers.stream()
    .max(Comparator.comparingDouble(Supplier::getTotalSales))
    .orElse(null);

if (topSupplier != null) {
    System.out.println(PINK+"-----------------------------------------------------");
    System.out.println("\nSupplier with the Most Sales:");
    System.out.println("   Supplier Name: " + topSupplier.getName());
    System.out.println("   Total Sales Volume: " + topSupplier.getTotalSales());
    System.out.println();
}

// Find Supplier with Least Sales
Supplier leastSupplier = allSuppliers.stream()
    .min(Comparator.comparingDouble(Supplier::getTotalSales))
    .orElse(null);

if (leastSupplier != null) {
    System.out.println("-----------------------------------------------------");
    System.out.println("\nSupplier with the Least Sales:");
    System.out.println("   Supplier Name: " + leastSupplier.getName());
    System.out.println("   Total Sales Volume: " + leastSupplier.getTotalSales());
    System.out.println("-----------------------------------------------------");
}

// Generate the report for all suppliers
// PART03: Generate Full Supplier Report
System.out.println(YELLOW + "PART03: Generate Full Supplier Report");

// Validate the input
if (allSuppliers == null || allSuppliers.isEmpty()) {
    System.out.println("No suppliers available for the report.");
} else {
    // Header for the report
    System.out.printf("%-5s %-20s %-15s %-20s %-70s\n", "Rank", "Supplier", "Total Sales", "Top Product", "The number of different Customers");
    System.out.println("----------------------------------------------------------------------");

    // Prepare a list to store supplier reports
    List<Object[]> supplierReports = new ArrayList<>();

    // Populate the supplier reports
    for (Supplier supplier : allSuppliers) {
        // Calculate total sales
        double totalSales = supplier.getTotalSales();

        // Find the top product by ceiling price
        Product topProduct = supplier.getProductCatalog()
                                      .getProductList()
                                      .stream()
                                      .max(Comparator.comparing(Product::getCeilingPrice))
                                      .orElse(null);

        // Count the number of unique customers for this supplier
        Set<CustomerProfile> uniquecustomers = new HashSet<>();
        for (Product product : supplier.getProductCatalog().getProductList()) {
            if (product.getCustomers() != null) {
                uniqueCustomers.addAll(product.getCustomers());
            }
        }
        long customerCount = uniqueCustomers.size();

        // Add the supplier report details to the list
        supplierReports.add(new Object[]{
                supplier.getName(),
                totalSales,
                topProduct != null ? topProduct.getName() : "N/A",
                customerCount
        });
    }

    // Sort the supplier reports by total sales in descending order
    supplierReports.sort((a, b) -> Double.compare((double) b[1], (double) a[1]));

    // Print the report
    int rank = 1;
    for (Object[] report : supplierReports) {
        System.out.printf("%-5d %-20s %-15.2f %-20s %-70d\n",
                rank++,
                report[0], // Supplier name
                report[1], // Total sales
                report[2], // Top product
                report[3]  // Customer count
        );
    }
}
}
}