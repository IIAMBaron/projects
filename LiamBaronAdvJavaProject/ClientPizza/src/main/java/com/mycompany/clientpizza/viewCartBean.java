/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientpizza;

/**
 *
 * @author EDUV4813733
 */
public class viewCartBean {
    private Object listQuantity;
    private Object listProdNames;
    private Object listProdPrices;


    private Object[] quantity;
    private Object[] names;
    private Object[] prices;

    conversion quan = new conversion();
    conversion name = new conversion();
    conversion price = new conversion();
    
    public viewCartBean() {
    }
    
    public void setCartBean(Object listQuantityPar, Object listProdNamesPar, Object listProdPricesPar) {
        listQuantity = listQuantityPar;
        listProdNames = listProdNamesPar;
        listProdPrices = listProdPricesPar;
    }
    public Object[] getQuantity() {
        return quantity;
    }

    public void setQuantity() {
        quan.setConversion(listQuantity);
        Object[] quantityPar = quan.getNames();
        quantity = quantityPar;
    }

    public Object[] getNames() {
        return names;
    }

    public void setNames() {
        name.setConversion(listProdNames);
        Object[] namesPar = name.getNames();
        names = namesPar;
    }

    public Object[] getPrices() {
        return prices;
    }

    public void setPrices() {
         price.setConversion(listProdPrices);
        Object[] pricesPar = price.getNames();
        prices = pricesPar;
    }
    
           
           
    

   
}
