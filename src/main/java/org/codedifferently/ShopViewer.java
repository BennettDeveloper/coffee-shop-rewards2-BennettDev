package org.codedifferently;

import org.codedifferently.data.CoffeeItem;
import org.codedifferently.data.Customer;
import org.codedifferently.helpers.CoreyeSpeak;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopViewer {
    public void performShopOperations(ArrayList<CoffeeItem> coffeeItems, Customer curCustomer)
    {
        Scanner scan = new Scanner(System.in);
        //Shopping for items.
        boolean isFinishedShopping = false;

        while(!isFinishedShopping) {
            System.out.println(CoreyeSpeak.coreyePrefix + "Here are the menu items for today.");
            for(int i = 0; i < coffeeItems.size(); i++) {
                System.out.print((i+1) + ". " + coffeeItems.get(i).getItemName());
                System.out.print(" |  $" + coffeeItems.get(i).getPrice());
                System.out.println();
            }

            System.out.println();
            System.out.println(CoreyeSpeak.coreyePrefix + "Which one would you like to buy?");
            System.out.println(CoreyeSpeak.coreyePrefix + "Type the number to view the item, or -1 to exit out of the shop.");
            System.out.println("Type your number below:");

            int itemOption = 0;

            boolean isValidItemChoice = false;
            while(!isValidItemChoice) {
                itemOption = scan.nextInt();
                //0-based indexing.
                if(itemOption != -1) itemOption -= 1;
                //System.out.println(itemOption);
                if(itemOption == -1) {
                    System.out.println("You've exited out of the shopping experience.");
                    isFinishedShopping = true;
                    break;
                }
                else if((itemOption < 0 || itemOption >= coffeeItems.size())) {
                    System.out.println(CoreyeSpeak.coreyePrefix + "That item is not on our menu, make sure to type the correct number!");
                }
                else {
                    isValidItemChoice = true;
                }
            }

            //Make sure it breaks out of the other loop if the user enters -1.
            if(isFinishedShopping) {
                break;
            }

            //from scan int to scan line, do this before the next scanLine
            scan.nextLine();

            //Loop for buying
            boolean isValidBuyOption = false;
            String buyOption = "";

            //user picked valid option, out of while loop
            System.out.println("----------------------------------------");
            System.out.println();
            System.out.print(coffeeItems.get(itemOption).getItemName());
            System.out.print(" | $ " + coffeeItems.get(itemOption).getPrice());
            System.out.println();
            System.out.println(coffeeItems.get(itemOption).getDescription());
            System.out.println();
            System.out.println("----------------------------------------");

            System.out.println(CoreyeSpeak.coreyePrefix + "Would you like to buy this item? (y/n)");

            while(!isValidBuyOption) {
                buyOption = scan.nextLine();
                if(buyOption.equals("y")) {
                    performBuyOperation(curCustomer, coffeeItems.get(itemOption));
                    isValidBuyOption = true;
                }
                else if (buyOption.equals("n")) {
                    isValidBuyOption = true;
                }
                else {
                    System.out.println(CoreyeSpeak.coreyePrefix + " that's not a yes (y) or no (n)! C'mon man!");
                }
            }
        }

    }

    void performBuyOperation(Customer customer, CoffeeItem coffeeItem) {
        System.out.println("You've bought one " + coffeeItem.getItemName() + "!");
        customer.addDrinkPurchase(coffeeItem);
    }
}
