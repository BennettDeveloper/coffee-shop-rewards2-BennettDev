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


        //Create default coffeeItems
        CoffeeItem espresso = new CoffeeItem("Espresso", "Bold and concentrated shot of pure coffee", 5.99, 1);
        CoffeeItem latte = new CoffeeItem("Latte", "Smooth espresso blended with steamed milk", 7.99, 1);
        CoffeeItem cappuccino = new CoffeeItem("Cappuccino", "Rich espresso topped with foamed milk", 8.99, 1);
        CoffeeItem macchiatto = new CoffeeItem("Macchiato", "Espresso marked with a touch of milk foam", 6.99, 1);
        CoffeeItem americano = new CoffeeItem("Americano", "Espresso diluted with hot water for a smooth finish", 5.99, 1);
        CoffeeItem mocha = new CoffeeItem("Mocha", "Chocolate flavored espresso with steamed milk", 7.99, 1);
        CoffeeItem avocadoToast = new CoffeeItem("Avocado Toast", "Toasted bread topped with fresh smashed avocado", 6.99, 1);
        CoffeeItem englishMuffin = new CoffeeItem("English Muffin Breakfast Sandwhich", "Savory breakfast sandwich on a toasted English muffin", 7.99, 1);
        CoffeeItem waffleBreakfast = new CoffeeItem("Waffle Breakfast Sandwhich", "Sweet and savory breakfast sandwich on a waffle bun", 7.99, 1);

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
        Customer newCustomer = new Customer(name);

        //Put in existing customer functionality.
        Customer existingCustomer = main.checkIfCustomerExists(name, customerList);
        if (existingCustomer != null) {
            System.out.println(CoreyeSpeak.coreyePrefix + "Wait I know you!! You're a frequent buyer already!");
            newCustomer = existingCustomer;
        }

        while (!isProgramRunning) {

            System.out.println(CoreyeSpeak.coreyePrefix + "Welcome " + newCustomer.getName() + "... to the COREYE' COFFEE CLUB");
            System.out.println("Budget: $" + String.format("%.2f",newCustomer.getBudget()));

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
                try {
                    optionInput = scan.nextInt();

                    if (optionInput > 0 && optionInput <= optionChoices) {
                        isValidOptionInput = true;
                    } else {
                        System.out.println("not a valid input, make sure your number is within range!");
                    }
                }
                catch(Exception e) {
                    System.out.println("Invalid input received, you probably typed a String instead of a number.");
                    scan.next();

                }
            }

            //Pick Option Input based on choices
            switch(optionInput) {
                case 1:
                    ShopViewer shopView = new ShopViewer();
                    shopView.performShopOperations(coffeeItems,newCustomer);
                    break;
                case 2:
                    ProductViewer productView = new ProductViewer();
                    productView.performProductOperations(newCustomer);
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