package org.codedifferently;

import org.codedifferently.data.CoffeeItem;
import org.codedifferently.data.Customer;
import org.codedifferently.helpers.CoreyeSpeak;

import java.util.ArrayList;
import java.util.Scanner;

public class ShopViewer {
    int curItemIndex = 0;

    public void performShopOperations(ArrayList<CoffeeItem> coffeeItems, Customer curCustomer)
    {
        Scanner scan = new Scanner(System.in);
        //Shopping for items.
        boolean isFinishedShopping = false;

        while(!isFinishedShopping) {
            System.out.println(CoreyeSpeak.coreyePrefix + "Here are the menu items for today.");
            for(int i = 0; i < coffeeItems.size(); i++) {
                System.out.print((i+1) + ". " + coffeeItems.get(i).getItemName());
                System.out.print(" |  $" + String.format("%.2f", coffeeItems.get(i).getPrice()));
                System.out.println();
            }

            System.out.println();
            System.out.println(CoreyeSpeak.coreyePrefix + "Which one would you like to buy?");
            System.out.println(CoreyeSpeak.coreyePrefix + "Type the number to view the item, " +
                    " or -1 to exit out of the shop.");
            System.out.println("Type your number below:");

            isFinishedShopping = promptToBuy(scan, coffeeItems.size());

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
            System.out.print(coffeeItems.get(curItemIndex).getItemName());
            System.out.print(" | $ " + String.format("%.2f", coffeeItems.get(curItemIndex).getPrice()));
            System.out.println();
            System.out.println(coffeeItems.get(curItemIndex).getDescription());
            System.out.println();
            System.out.println("----------------------------------------");

            System.out.println(CoreyeSpeak.coreyePrefix + "Would you like to buy this item? (y/n)");

            while(!isValidBuyOption) {
                buyOption = scan.nextLine();
                if(buyOption.equals("y")) {
                    int amount = promptBuyAmount(scan);
                    performBuyOperation(curCustomer, coffeeItems.get(curItemIndex),amount);
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

    boolean promptToBuy(Scanner scan, int coffeeItemSize) {
        boolean isValidItemChoice = false;
        int itemOption = 0;
        while(!isValidItemChoice) {
            try {
                itemOption = scan.nextInt();
                //0-based indexing.
                if(itemOption != -1) itemOption -= 1;
                //System.out.println(itemOption);
                if(itemOption == -1) {
                    System.out.println("You've exited out of the shopping experience.");
                    return true;
                }
                else if((itemOption < 0 || itemOption >= coffeeItemSize)) {
                    System.out.println(CoreyeSpeak.coreyePrefix + "That item is not on our menu, " +
                            "make sure to type the correct number!");
                }
                else {
                    curItemIndex = itemOption;
                    isValidItemChoice = true;
                }


            }
            catch (Exception e) {
                System.out.println("Invalid input received, you probably typed a String instead of a number.");
                scan.next();
            }
        }
        return false;
    }

    int promptBuyAmount(Scanner scan) {
        int amountInput = 0;
        boolean hasEnteredAmount = false;
        while(!hasEnteredAmount) {
            try {
                System.out.println("How many would you like to buy?");
                amountInput = scan.nextInt();

                return amountInput;
            }
            catch (Exception e) {
                System.out.println("Invalid Input, you must've typed a String instead of an Intger");
                scan.next();
            }

        }
        return 1;
    }

    void performBuyOperation(Customer customer, CoffeeItem coffeeItem, int amount) {
        System.out.println("You've bought " + amount + " " + coffeeItem.getItemName() + ((amount < 1) ? "" : "s") +  "!");
        customer.addDrinkPurchase(coffeeItem, amount);
    }
}
