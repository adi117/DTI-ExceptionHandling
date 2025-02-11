package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        List<Integer> numberList = CalculateAverage.readNumber();
//        System.out.println(CalculateAverage.calculateAverage(numberList));


        try {
            Scanner scannerProductData = new Scanner(new File("/Users/muhammadadiwicaksono/Downloads/product_sales_data.csv")).useDelimiter(",");

            while (scannerProductData.hasNext()){
                String row = scannerProductData.nextLine();
                String[] rowArray = row.split(",");

                int limiter = 0;

                for (String rowValue : rowArray){
                    limiter++;
                    System.out.print(rowValue + " | ");
                    if (limiter == 3){
                        System.out.println();
                    }
                }
            }
            scannerProductData.close();

        } catch (FileNotFoundException e){
            System.out.println("Input the correct file path!");
        }


    }
}