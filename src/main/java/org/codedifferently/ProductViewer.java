package org.codedifferently;

import org.codedifferently.data.CoffeeItem;
import org.codedifferently.data.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductViewer
{
    public void performProductOperations(Customer curCustomer) {

        Scanner scan = new Scanner(System.in);
        System.out.println("-------------------------------");
        System.out.println("       " + curCustomer.getName().toUpperCase() + "       ");
        System.out.println();
        System.out.println("email: " + curCustomer.getEmaill());
        System.out.println("budget: $" + String.format("%.2f", curCustomer.getBudget()));
        System.out.println("total money spent: $" + String.format("%.2f", curCustomer.getMoneySpent()));
        System.out.println("products purchased: ");

        if(curCustomer.getDrinksPurchased().size() < 1) {
            System.out.println("No products purchased yet...");
        }
        else {
            for (int i = 0; i < curCustomer.getDrinksPurchased().size(); i++) {
                CoffeeItem curItem = curCustomer.getDrinksPurchased().get(i);
                System.out.println((i+1) + ": " + curItem.getItemName() + " x." + curItem.getAmount());
            }
        }
        System.out.println("Golden Tickets: " + curCustomer.getGoldenTickets());
        System.out.println();
        System.out.println();

        System.out.println("Type anything to continue.");
        System.out.println("-------------------------------");
        scan.nextLine();
    }
}
