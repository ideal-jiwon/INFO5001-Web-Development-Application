/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;

/**
 *
 * @author kal bugrara
 */
public class Supplier {
    String name;
    ProductCatalog productcatalog;
    ProductsReport productsreport;
    float totalSales; 

    public Supplier(String n) {
        this.name = n;
        this.productcatalog = new ProductCatalog(name);  
        this.totalSales = 0.0f;
    }
    
    public ProductsReport prepareProductsReport() {
        productsreport = productcatalog.generatProductPerformanceReport();
        return productsreport;
    }
    
    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {
        if (productsreport == null) productsreport = prepareProductsReport();
        return productsreport.getProductsAlwaysAboveTarget();
    }
    
    public String getName() {
        return name;
    }
    public float calculateTotalSalesVolume() {
    float totalSalesVolume = 0.0f;

    // Loop through the products in the supplier's product catalog and sum their sales volumes
    for (Product product : productcatalog.getProductList()) {
        totalSalesVolume += product.getSalesVolume();
    }

    this.totalSales = totalSalesVolume; // Update totalSales for the supplier
    return totalSalesVolume;
}

    public ProductCatalog setProductCatalog(ProductCatalog catalog) {
        this.productcatalog = catalog;
        return catalog;
    }
    
    public ProductCatalog getProductCatalog() {
        return productcatalog;
    }

    public void setTotalSales(float totalSales) {
        this.totalSales = totalSales;
    }

    public float getTotalSales() {
        return totalSales;
    }

    @Override
    public String toString() {
        return "Supplier Account Information: " +
              "Supplier Name: " + name +
              ", Product Catalog: " + productcatalog;
    }
}