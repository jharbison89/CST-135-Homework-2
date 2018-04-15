/**
 * Program: CST-135-Homework-2
 * File: Drink.java
 * Summary:
 * Author: Chase Hausman
 * Date: April 14, 2018
 */
public abstract class Drink extends Product{
    private int size; // Drink size in ounces

    public Drink() {
        this.size = 16;
    }

    public Drink(int size) {
        this.size = size;
    }

    public Drink(Drink initial) {
        this.size = initial.size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSize (ounces)\t" + this.getSize();
    }
}
