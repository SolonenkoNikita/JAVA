import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private final List<Item> items = new ArrayList<>();

    private static class Item {
        String description;
        int quantity;
        double unitPrice;

        double price() {
            return quantity * unitPrice;
        }

        @Override
        public String toString() {
            return "description = " + description + " quantity = " + quantity +
                    " unitPrice = " + unitPrice + " price = " + price();
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public double allPrice() {
        double result = 0;
        for (Item it : items)
            result += it.price();
        return result;
    }

    public Item getItem(int i) {
        if (i >= 0 && i < items.size())
            return items.get(i);
        throw new ArrayIndexOutOfBoundsException("Invalid index");
    }

    private Item createItem(String description, int quantity, double unitPrice) {
        Item item = new Item();
        item.description = description;
        item.quantity = quantity;
        item.unitPrice = unitPrice;
        return item;
    }

    public void addItem(String description, int quantity, double unitPrice) {
        Item item = createItem(description, quantity, unitPrice);
        items.add(item);
    }

    @Override
    public String toString() {
        return "items = " + items;
    }

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.addItem("Doll", 1, 5000);
        System.out.println(invoice.getItems());
        System.out.println(invoice);
    }
}