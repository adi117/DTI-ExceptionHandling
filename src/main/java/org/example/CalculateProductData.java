package org.example;

import java.util.ArrayList;
import java.util.List;

public class CalculateProductData {
    private static List<String> productList = new ArrayList<>();
    private static List<Integer> itemSoldList = new ArrayList<>();
    private static List<Double> itemPriceList = new ArrayList<>();
    private static String[] mostSoldProduct = new String[2];
    private static String[] leastSoldProduct = new String[2];


    public static void addProductInformationList(String productName, int itemSold, double itemPrice){
        productList.add(productName);
        itemPriceList.add(itemPrice);
        itemSoldList.add(itemSold);

        checkLeastSoldProduct(productName, itemSold);
        checkMostSoldProduct(productName, itemSold);
    }

    public static int getItemSoldList(){
        int sumSoldProduct = 0;

        for (int quantity : itemSoldList){
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

    public static String[] checkMostSoldProduct(String productName, int itemSold){
        if (mostSoldProduct[0] == null){
            mostSoldProduct[0] =productName;
            mostSoldProduct[1] = String.valueOf(itemSold);
        }

        if (itemSold > Integer.parseInt(mostSoldProduct[1])){
            mostSoldProduct[0] =productName;
            mostSoldProduct[1] = String.valueOf(itemSold);
        }

        return mostSoldProduct;
    }

    public static String[] checkLeastSoldProduct(String productName, int itemSold){
        if (leastSoldProduct[0] == null){
            leastSoldProduct[0] =productName;
            leastSoldProduct[1] = String.valueOf(itemSold);
        }

        if (itemSold < Integer.parseInt(leastSoldProduct[1])){
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
