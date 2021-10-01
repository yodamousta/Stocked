package com.stocked;

import com.stocked.entities.Stock;
import com.stocked.utils.Logger;

import java.util.Scanner;

public class Main {

    private static Stock stock;

    public static void main(String[] args) {
        System.out.println("Enter a maximum stock size : ");
        Scanner reader = new Scanner(System.in);
        init(reader.nextInt());
        System.out.println(Stock.maxSize);
        Boolean stop = false;

        while (!stop){
            String input = reader.nextLine();
            if(input.equals("stop")){
                stop = true;
            } else if (input.equals("clear")){
                if(stock.clear()){
                    Logger.fine("Stock cleared by admin.");
                } else {
                    Logger.fine("Admin is not strong enough to clear empty stock.");
                }
            } else if (input.equals("push")){
                System.out.println("Entrez un ID: ");
                int id = reader.nextInt();
                System.out.println("Entrez une valeur: ");
                int value = reader.nextInt();
                if (stock.push(id, value)){
                    Logger.fine("Product successfully added to stock by admin.");
                } else {
                    Logger.severe("Admin is not strong enough to bypass maximum size of stock.");
                }
            } else if (input.equals("pop")){
                if (stock.pop()){
                    Logger.fine("Product popped by admin.");
                } else {
                    Logger.severe("Admin is not strong enough to pop from empty stock.");
                }
            } else {
                System.out.println("Please use \"stop\" to stop; \"push\" to push; \"pop\" to pop; \"clear\" to clear the stock.");
            }
        }
    }

    public static void init(int maxSize){
        stock = new Stock(maxSize);
    }
}
