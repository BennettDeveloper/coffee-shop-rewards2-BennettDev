package org.codedifferently.data;

public class CoffeeItem {
    private String itemName;
    private String description;
    private int amount;
    private double price;
    private boolean isDrink;


    //Default Constructor
    public CoffeeItem() {

    }

    //Parameter Constructor
    public CoffeeItem(String itemName, String description, double price, int amount) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
