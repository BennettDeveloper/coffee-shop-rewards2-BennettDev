package org.codedifferently.data;

import org.codedifferently.helpers.CoreyeSpeak;

import java.util.ArrayList;
import java.util.Random;

public class Customer {
    private String name;
    private String emaill;
    private int points;
    private ArrayList<CoffeeItem> drinksPurchased;

    private double moneySpent;
    private int goldenTickets = 0;
    private boolean freeNextDrink = false;

    private final int amountTillGolden = 100;
    private int totalAmounts = 0;

    //Default (new customer)
    public Customer(String name) {
        this.name = name;
        this.emaill = generateNewEmail(name);
        this.points = 0;
        this.moneySpent = 0;
        this.drinksPurchased = new ArrayList<>();
        freeNextDrink = false;
    }

    //Existing customer
    public Customer(String name, String email, int points, ArrayList<CoffeeItem> drinksPurchased) {
        this.name = name;
        this.emaill = email;
        this.points = points;
        this.drinksPurchased = drinksPurchased;
        this.moneySpent = 0;

        if(email.isEmpty()) {
            this.emaill = generateNewEmail(name);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }

    public int getGoldenTickets() {
        return goldenTickets;
    }

    public void setGoldenTickets(int goldenTickets) {
        this.goldenTickets = goldenTickets;
    }


    public ArrayList<CoffeeItem> getDrinksPurchased() {
        return drinksPurchased;
    }

    public void addDrinkPurchase(CoffeeItem newDrinkPurchased, int amount) {

        for(int i = 1; i <= amount; i++) {

            if(goldenTickets > 0) {
                System.out.println("Golden Ticket utilized! the " + newDrinkPurchased.getItemName() +
                        " is now free!");
                goldenTickets--;
            }
            else {
                if(!freeNextDrink) {
                    moneySpent += newDrinkPurchased.getPrice();
                }
                else {
                    freeNextDrink = false;
                }
            }

            int indexFound = checkIfDrinkInInventory(newDrinkPurchased);
            if (indexFound != -1) {
                CoffeeItem foundDrink = drinksPurchased.get(indexFound);
                foundDrink.setAmount(foundDrink.getAmount() + 1);
            }
            else {
                drinksPurchased.add(newDrinkPurchased);
            }

            if (i % 5 == 0) {
                checkRewardEligibility(i);
            }
        }

        totalAmounts += amount;
        if( totalAmounts >= amountTillGolden) {
            System.out.println(CoreyeSpeak.coreyePrefix + "YOU'VE BOUGHT 100 ITEMS AT MY STORE!!");
            System.out.println(CoreyeSpeak.coreyePrefix + "I'M GIVING YOU 1 FREE GOLDEN TICKET");
            goldenTickets++;
            totalAmounts = 0;
        }

    }

    public int checkIfDrinkInInventory(CoffeeItem newItem) {

        //What is an array, what problems do they solve,
        //What problems do arrays solve
        //What is zero-based indexing
        //How to declare array
        //Where are arrays stored in memory

        //1 common mistake, 1 knowledge check question, 2 working code examples.
        if(drinksPurchased.isEmpty()) return -1;

        for (int i = 0; i < drinksPurchased.size(); i++) {
            if(drinksPurchased.get(i).getItemName().equals(newItem.getItemName())) {
                return i;
            }
        }
        return -1;
    }

    public void checkRewardEligibility(int amount) {
        System.out.println("Since you've gotten to " + amount + " drinks! " +
                "You are eligible for a Reward!!!");
        System.out.println(" Next purchase is on us! ");
        freeNextDrink = true;
    }

    public String generateNewEmail(String name) {
        Random random = new Random();

        int spaceIndex = name.indexOf(' ');
        if (spaceIndex != -1) {
            return name.substring(0,spaceIndex) + name.substring(spaceIndex) + random.nextInt(11,261) + "@cffeeclub.com";
        }
        else {
            return name + random.nextInt(11,261) + "@cffeeclub.com";
        }
    }
}
