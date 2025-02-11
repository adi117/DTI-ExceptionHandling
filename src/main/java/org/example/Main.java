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


        Scanner scannerProductData = new Scanner(new File("/Users/muhammadadiwicaksono/Downloads/product_sales_data.csv")).useDelimiter(",");
        while (scannerProductData.hasNext()){
            System.out.print(scannerProductData.next() + ",");
        }
        scannerProductData.close();
    }
}