package org.codedifferently;

import org.codedifferently.data.CoffeeItem;
import org.codedifferently.data.Customer;
import org.codedifferently.helpers.CoreyeSpeak;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Create default customers.
        Customer bryant = new Customer("bryant", "bryfer@gmail.com", 0, new ArrayList<>());
        Customer michael = new Customer("michael", "micmos@gmail.com", 0, new ArrayList<>());
        Customer jordan = new Customer("jordan", "jorel@gmail.com", 0, new ArrayList<>());
        Customer coreye = new Customer("coreye", "corros@gmail.com", 0, new ArrayList<>());
        Customer glenn  = new Customer("glenn", "gletys@gmail.com", 0, new ArrayList<>());

        //Add them to list
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(bryant);
        customerList.add(michael);
        customerList.add(jordan);
        customerList.add(coreye);
        customerList.add(glenn);

        //Create default coffeeItems
        CoffeeItem espresso = new CoffeeItem("Espresso", "Bold and concentrated shot of pure coffee", 25, true);
        CoffeeItem latte = new CoffeeItem("Latte", "Smooth espresso blended with steamed milk", 12, true);
        CoffeeItem cappuccino = new CoffeeItem("Cappuccino", "Rich espresso topped with foamed milk", 11, true);
        CoffeeItem macchiatto = new CoffeeItem("Macchiato", "Espresso marked with a touch of milk foam", 16, true);
        CoffeeItem americano = new CoffeeItem("Americano", "Espresso diluted with hot water for a smooth finish", 15, true);
        CoffeeItem mocha = new CoffeeItem("Mocha", "Chocolate flavored espresso with steamed milk", 18, true);
        CoffeeItem avocadoToast = new CoffeeItem("Avocado Toast", "Toasted bread topped with fresh smashed avocado", 11, false);
        CoffeeItem englishMuffin = new CoffeeItem("English Muffin Breakfast Sandwhich", "Savory breakfast sandwich on a toasted English muffin", 14, false);
        CoffeeItem waffleBreakfast = new CoffeeItem("Waffle Breakfast Sandwhich", "Sweet and savory breakfast sandwich on a waffle bun", 15, false);

        //Add them to list
        ArrayList<CoffeeItem> coffeeItems = new ArrayList<>();
        coffeeItems.add(espresso);
        coffeeItems.add(latte);
        coffeeItems.add(cappuccino);
        coffeeItems.add(macchiatto);
        coffeeItems.add(americano);
        coffeeItems.add(mocha);
        coffeeItems.add(avocadoToast);
        coffeeItems.add(englishMuffin);
        coffeeItems.add(waffleBreakfast);

        //Scan user input for their name
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println(CoreyeSpeak.coreyePrefix + "Welcome to the CCC, Where you Consume Cocoa Cups.");
        System.out.println();
        System.out.println("         COREYE' COFFEE CLUB");
        System.out.println("-----------------------------------------------");


        //Set new customer name and other fields
        Main main = new Main();
        String name = "bryant";
        name = main.promptNameIntro(scan);

        boolean isProgramRunning = false;

        while (!isProgramRunning) {

            Customer newCustomer = new Customer(name);
            System.out.println(CoreyeSpeak.coreyePrefix + "Welcome " + newCustomer.getName() + "... to the COREYE' COFFEE CLUB");

            //Put in existing customer functionality.
            Customer existingCustomer = main.checkIfCustomerExists(name, customerList);
            if (existingCustomer != null) {
                System.out.println(CoreyeSpeak.coreyePrefix + "Wait I know you!! You're a frequent buyer already!");
                newCustomer = existingCustomer;
            }

            System.out.println("Use these options to navigate around my store!");
            System.out.println("----------------------------------------------");

            System.out.println("1. Enter Shop");
            System.out.println("2. View Purchased Products");
            System.out.println("3. Exit Experience.");
            System.out.println("----------------------------------------------");
            System.out.println("Type your response as an input below:");
            System.out.println();

            boolean isValidOptionInput = false;
            int optionInput = 0;
            final int optionChoices = 3;

            while(!isValidOptionInput) {
                optionInput = scan.nextInt();

                if (optionInput > 0 && optionInput <= optionChoices) {
                    isValidOptionInput = true;
                } else {
                    System.out.println("not a valid input, make sure your number is within range!");
                }
            }

            //Pick Option Input based on choices
            switch(optionInput) {
                case 1:
                    ShopViewer shop = new ShopViewer();
                    shop.performShopOperations(coffeeItems,newCustomer);
                    break;
                case 2:
                    System.out.println("View stats is not available at this time.");
                    break;
                case 3:
                    System.out.println(CoreyeSpeak.coreyePrefix + "Alright, have a nice day!");
                    isProgramRunning = true;
                    break;
            }

        }

    }

    Customer checkIfCustomerExists(String name, ArrayList<Customer> customerList) {
        for (int i = 0; i < customerList.size(); i++) {
            //check if names are the same.
            if (customerList.get(i).getName().equals(name)) {
                return customerList.get(i);
            }
        }
        return null;
    }

    String promptNameIntro(Scanner scan) {
        System.out.println(CoreyeSpeak.coreyePrefix + "What is your name fellow Coffee Club member?");
        System.out.println();

        String name = scan.nextLine();
        name = name.toLowerCase();

        System.out.println(CoreyeSpeak.coreyePrefix + "Wow, " + name + " that's beautiful.");
        return name;
    }

}