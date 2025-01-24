/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Supplier.*;
/**
 *
 * @author kal bugrara
 */
public class ProductCatalog {

    String type;
    ArrayList<Product> products; //list of products initially empty
    private Supplier supplier;
    
    public ProductCatalog(String productType, Supplier supplier) {
        this.supplier = supplier;
        type = productType;
        products = new ArrayList<>();  ///create the list of elements otherwise it is null
    }
// new ProductCatalog(); or new ProductCatalog("Printers");
    public ProductCatalog(String type) {
        type = "unknown";
        products = new ArrayList<>();
    }
    public Product newProduct(String n, float fp, float cp, float tp, Supplier supplier) {
        Product p = new Product(n, fp, cp, tp);
        p.setSupplier(supplier);
        products.add(p);
        return p;
        
    }

    public ProductsReport generatProductPerformanceReport() {
        ProductsReport productsreport = new ProductsReport();

        for (Product p : products) {

            ProductSummary ps = new ProductSummary(p);
            productsreport.addProductSummary(ps);
        }
        return productsreport;
    }
    public void loadProductsFromCSV(String filePath,List<Supplier> supplierList) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
    
            // Skip the header line
            br.readLine();
    
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
    
                // Parse product details
                String name = values[2].trim();
                String supplierName = values[6].trim();
                float floorPrice = Float.parseFloat(values[3].trim());
                float ceilingPrice = Float.parseFloat(values[4].trim());
                float targetPrice = Float.parseFloat(values[5].trim());
                
    
                // Find the supplier by name
                Supplier supplier = supplierList.stream()
                .filter(s -> s.getName().equalsIgnoreCase(supplierName))
                .findFirst()
                .orElse(null);

        if (supplier != null) {
            // Add product to the catalog and link it to the supplier
            Product product = newProduct(name, floorPrice, ceilingPrice, targetPrice, supplier);
            supplier.getProductCatalog().addProduct(product);
        }
    }
} catch (IOException | NumberFormatException e) {
    System.err.println("Error loading products from CSV: " + e.getMessage());
}
}
public void addProduct(Product product) {
    products.add(product);
}

    public ArrayList<Product> getProductList(){
        return products;
    }
    public static List<Product> getSupplierList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSupplierList'");
    }
    
        public Product findMostExpensiveProduct() {
            Product mostExpensiveProduct = null;
    
            for (Product product : products) {
                if (mostExpensiveProduct == null || product.getCeilingPrice() > mostExpensiveProduct.getCeilingPrice()) {
                    mostExpensiveProduct = product;
                }
            }
            return mostExpensiveProduct;
        }

}




