package ru.npsolonenko;

class DiscountedItem extends Item {

    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }


    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject))
            return false;

        if (otherObject instanceof DiscountedItem) {
            DiscountedItem other = (DiscountedItem) otherObject;
            return this.discount == other.discount;
        }

        return true; //without discount there's Item (not DiscountedItem)
    }

    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str1));

        /*Item x = new Item("Book", 10.0);
        DiscountedItem y = new DiscountedItem("Book", 10.0, 1.0);
        Item z = new Item("Book", 10.0);

        System.out.println(x.equals(y));
        System.out.println(y.equals(z));*/

    }
}
