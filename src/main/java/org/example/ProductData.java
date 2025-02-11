package org.example;

public class ProductData {
    private String productName;
    private int totalSold;
    private double itemPrice;

    public ProductData(String productName, int totalSold, double itemPrice){
        this.productName = productName;
        this.totalSold = totalSold;
        this.itemPrice = itemPrice;

        sendProductData();
    }

    public void sendProductData() {
        CalculateProductData.addProductInformationList(productName, totalSold, itemPrice);
    }

}
