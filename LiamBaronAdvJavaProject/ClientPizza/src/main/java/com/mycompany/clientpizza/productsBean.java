package com.mycompany.clientpizza;

public class productsBean {
    private int prodID;
    private String prodName;
    private float prodPrice;
    private String prodDesc;
    private String prodImage;
    
    public productsBean(Object[] products) {
        // putting the elements into their appropriate variable names
        this.prodID = Integer.parseInt(products[0].toString());
        this.prodName = products[1].toString();
        System.out.println(prodName);
        this.prodPrice = Float.parseFloat((String)products[2]);
        System.out.println(prodPrice);
        this.prodDesc = (String)products[3];
        System.out.println(prodDesc);
        this.prodImage = (String)products[4];
        System.out.println(prodImage);
    }

    public int getProdID() {
        return prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public float getProdPrice() {
        return prodPrice;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public String getProdImage() {
        return prodImage;
    }
    
}
