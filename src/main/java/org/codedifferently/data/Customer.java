package org.codedifferently.data;

import java.util.ArrayList;
import java.util.Random;

public class Customer {
    private String name;
    private String emaill;
    private int points;
    private ArrayList<CoffeeItem> drinksPurchased;

    //Default (new customer)
    public Customer(String name) {
        this.name = name;
        this.emaill = generateNewEmail(name);
        this.points = 0;
        this.drinksPurchased = new ArrayList<>();
    }

    //Existing customer
    public Customer(String name, String email, int points, ArrayList<CoffeeItem> drinksPurchased) {
        this.name = name;
        this.emaill = email;
        this.points = points;
        this.drinksPurchased = drinksPurchased;

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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public void addDrinkPurchase(CoffeeItem newDrinkPurchased) {
        drinksPurchased.add(newDrinkPurchased);
    }

    public boolean checkRewardEligibility() {

        if(drinksPurchased.size() >= 5) {
            System.out.println("You are eligible for a Reward!!!");
            return true;
        }
        return false;
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
