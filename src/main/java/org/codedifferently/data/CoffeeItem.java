package org.codedifferently.data;

public class CoffeeItem {
    private String itemName;
    private String description;
    private double price;
    private boolean isDrink;


    //Default Constructor
    public CoffeeItem() {

    }

    //Parameter Constructor
    public CoffeeItem(String itemName, String description, double price, boolean isDrink) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.isDrink = isDrink;
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

    public boolean isDrink() {
        return isDrink;
    }

    public void setDrink(boolean drink) {
        isDrink = drink;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
