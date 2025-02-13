package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        List<Integer> numberList = CalculateAverage.readNumber();
//        System.out.println(CalculateAverage.calculateAverage(numberList));


        try {
            Scanner scannerProductData = new Scanner(new File("/Users/muhammadadiwicaksono/IdeaProjects/DTI-Week 2/DTI-ErrorAndExceptionHandling/ExceptionHandling/src/main/resources/product_sales_data.csv"));

            boolean isFirstRow = true;

            while (scannerProductData.hasNextLine()){
                String row = scannerProductData.nextLine();

                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                String[] rowArray = row.split(",");
                List<String> rowList = new ArrayList<>(List.of(rowArray));

                if (rowList.size() >= 3){
                    try {
                        String productName = "";
                        double totalSold = 0;
                        double itemPrice = 0.0;

                        for (int i = 0; i < 3; i++){
                            if (i == 0){
                                productName = rowList.get(i);
                            } else if (i == 1){
                                totalSold = Double.parseDouble(rowList.get(i));
                            } else {
                                itemPrice = Double.parseDouble(rowList.get(i));
                            }
                        }

                        CalculateProductData.addProductInformationList(productName, totalSold, itemPrice);
                    } catch (NumberFormatException e){
                        System.out.println("Error! The value is not a number.");
                    }
                }
            }
            scannerProductData.close();
        } catch (FileNotFoundException e){
            System.out.println("Input the correct file path!");
        }

        System.out.println("Total sales : " + CalculateProductData.getTotalSales());
        System.out.println("Total product sold : " + CalculateProductData.getTotalProductSold());
        System.out.println("Most bought product : " + CalculateProductData.getMostSoldProduct());
        System.out.println("Least bought product : " + CalculateProductData.getLeastSoldProduct());


    }
}