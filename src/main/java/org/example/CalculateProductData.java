package org.example;

import java.util.ArrayList;
import java.util.List;

public class CalculateProductData {
    private static List<String> productList = new ArrayList<>();
    private static List<Double> itemSoldList = new ArrayList<>();
    private static List<Double> itemPriceList = new ArrayList<>();
    private static String[] mostSoldProduct = new String[2];
    private static String[] leastSoldProduct = new String[2];


    public static void addProductInformationList(String productName, double itemSold, double itemPrice){
        productList.add(productName);
        itemPriceList.add(itemPrice);
        itemSoldList.add(itemSold);

        checkLeastSoldProduct(productName, itemSold);
        checkMostSoldProduct(productName, itemSold);
    }

    public static double getTotalProductSold(){
        double sumSoldProduct = 0;

        for (double quantity : itemSoldList){
            sumSoldProduct += quantity;
        }
        return sumSoldProduct;
    }

    public static double getTotalSales(){
        double totalSales = 0;

        for (int i = 0; i < productList.size(); i++ ){
            totalSales += itemSoldList.get(i) * itemPriceList.get(i);
        }

        return Math.round(totalSales*100.0)/100;
    }

    private static String[] checkMostSoldProduct(String productName, double itemSold){
        if (mostSoldProduct[0] == null){
            mostSoldProduct[0] =productName;
            mostSoldProduct[1] = String.valueOf(itemSold);
        }

        if (itemSold > Double.parseDouble(mostSoldProduct[1])){
            mostSoldProduct[0] =productName;
            mostSoldProduct[1] = String.valueOf(itemSold);
        }

        return mostSoldProduct;
    }

    private static String[] checkLeastSoldProduct(String productName, double itemSold){
        if (leastSoldProduct[0] == null){
            leastSoldProduct[0] =productName;
            leastSoldProduct[1] = String.valueOf(itemSold);
        }

        if (itemSold < Double.parseDouble(leastSoldProduct[1])){
            leastSoldProduct[0] =productName;
            leastSoldProduct[1] = String.valueOf(itemSold);
        }

        return leastSoldProduct;
    }

    public static String getMostSoldProduct(){
        return mostSoldProduct[0];
    }

    public static String getLeastSoldProduct(){
        return leastSoldProduct[0];
    }
}
