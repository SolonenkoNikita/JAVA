package ru.npsolonenko;

import java.util.Objects;

class Item {
    private String description;
    private double price;

    public Item(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject)
            return true;
        if (otherObject == null)
            return false;
        if (!(otherObject instanceof Item))
            return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description)
                && price == other.price;
    }

}
