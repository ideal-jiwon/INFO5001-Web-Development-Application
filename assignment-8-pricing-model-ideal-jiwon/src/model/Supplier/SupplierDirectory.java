/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.ProductManagement.ProductCatalog;

/**
 * Supplier Directory to manage suppliers and load them from a CSV file.
 * Author: Kal Bugrara
 */
public class SupplierDirectory {
    private List<Supplier> supplierList;
    
    public SupplierDirectory() {
        this.supplierList = new ArrayList<>();
    }
    
    public Supplier newSupplier(String name) {
        Supplier supplier = new Supplier(name);
        supplierList.add(supplier);
        return supplier;
    }
    
    public Supplier findSupplier(String id) {
        for (Supplier supplier : supplierList) {
            if (supplier.getName().equals(id)) {
                return supplier;
            }
        }
        return null;
    }
    
    public List<Supplier> getSupplierList() {
        return supplierList;
    }
    
    public void setSupplierList(List<Supplier> supplierList) {
        this.supplierList = supplierList;
    }

    // Method to load suppliers from a CSV file
    public void SuppliersFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Skip the header line
            br.readLine();

            // Read and process each line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // Extract supplier data
                String supplierName = values[1].trim(); 
                String productCatalogType = values[2].trim(); 

                // Create a new Supplier and set its ProductCatalog
                Supplier supplier = new Supplier(supplierName);
                supplier.setProductCatalog(new ProductCatalog(productCatalogType));

                // Add the supplier to the list
                supplierList.add(supplier);
            }
        } catch (IOException e) {
            System.err.println("Error loading suppliers from CSV: " + e.getMessage());
        }
    }
    public void calculateAndDisplaySupplierSales() {
        float highestSales = Float.MIN_VALUE;
        float lowestSales = Float.MAX_VALUE;
    
        Supplier topSupplier = null;
        Supplier bottomSupplier = null;
    
        System.out.println("\nSupplier Sales Volume Report:");
    
        for (Supplier supplier : supplierList) {
            float salesVolume = supplier.calculateTotalSalesVolume();
            System.out.println("Supplier: " + supplier.getName() + ", Total Sales Volume: " + salesVolume);
    
            if (salesVolume > highestSales) {
                highestSales = salesVolume;
                topSupplier = supplier;
            }
    
            if (salesVolume < lowestSales) {
                lowestSales = salesVolume;
                bottomSupplier = supplier;
            }
        }
    
        // Display suppliers with the highest and lowest sales
        if (topSupplier != null) {
            System.out.println("\nSupplier with the Most Sales:");
            System.out.println("   Supplier Name: " + topSupplier.getName());
            System.out.println("   Total Sales Volume: " + highestSales);
        }
    
        if (bottomSupplier != null) {
            System.out.println("\nSupplier with the Least Sales:");
            System.out.println("   Supplier Name: " + bottomSupplier.getName());
            System.out.println("   Total Sales Volume: " + lowestSales);
        }
    }
}