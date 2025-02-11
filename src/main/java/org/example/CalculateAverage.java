package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculateAverage {

    public static List<Integer> readNumber(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> numberList = new ArrayList<>();

        while (true){
            System.out.print("Input your number : ");
            String number = scanner.next().toLowerCase();

            if (number.equals("q")){
                break;
            }

            try{
                addNumber(numberList, number);
            } catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number or 'q' to finish.");
            }
        }

        return numberList;
    }

    private static void addNumber(List<Integer> numberList, String number) throws NumberFormatException{
        numberList.add(Integer.parseInt(number));
    }

    public static double calculateAverage(List<Integer> numberList){
        double sum = 0;
        for (int number : numberList){
            sum += number;
        }

        return sum / numberList.size();
    }
}
