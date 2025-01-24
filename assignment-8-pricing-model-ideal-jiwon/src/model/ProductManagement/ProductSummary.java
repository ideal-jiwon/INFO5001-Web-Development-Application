/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

/**
 *
 * @author kal bugrara
 */

//this class will extract summary data from the product
public class ProductSummary {
    Product subjectproduct;
    float numberofsalesabovetarget;
    float numberofsalesbelowtarget;
    float productpriceperformance; //total profit above target --could be negative too
    float acutalsalesvolume;
    int rank; // will be done later
    
    public ProductSummary(Product p){
        
        numberofsalesabovetarget = p.getNumberOfProductSalesAboveTarget();
        productpriceperformance = p.getOrderPricePerformance();
        subjectproduct = p; //keeps track of the product itself not as well;
        acutalsalesvolume = p.getSalesVolume();
        numberofsalesbelowtarget = p.getNumberOfProductSalesBelowTarget();
    
    }
    
    public float getSalesRevenues(){
        return acutalsalesvolume;
    }
    public float getNumberAboveTarget(){
        return numberofsalesabovetarget;
    }
    public float getProductPricePerformance(){
        return productpriceperformance;
    }
    public float getNumberBelowTarget(){
        return numberofsalesbelowtarget;
    }            
    public boolean isProductAlwaysAboveTarget(){
        return false; // to be implemented
    }
}
