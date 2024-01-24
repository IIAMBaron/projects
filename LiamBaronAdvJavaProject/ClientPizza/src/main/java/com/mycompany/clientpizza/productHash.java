package com.mycompany.clientpizza;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author EDUV4813733
 */
public class productHash {
    static Map<String, Integer> productQuantity = new HashMap<>();
    static Map<Integer, String> productIDs = new HashMap<>();

    public void setProductQuantity(Map<String, Integer> productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductIDs(Map<Integer, String> productIDs) {
        this.productIDs = productIDs;
    }

    
    
    public void putIDs(int id, String name) {
        productIDs.put(id, name);
    }
    
    public void putProdQuantity(String name, int quantity) {
        productQuantity.put(name, quantity);
    }
    
    public void plusProdQuantity(String name, int quantity) {
        productQuantity.put(name,productQuantity.get(name) +quantity);
    }
    
    public void clearAllHash() {
        productIDs.clear();
        productQuantity.clear();
    }

    public Map<String, Integer> getProductQuantity() {
        return productQuantity;
    }

    public Map<Integer, String> getProductIDs() {
        return productIDs;
    }
    
}
