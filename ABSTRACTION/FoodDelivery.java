abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    abstract void calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

interface Discountable {
    public void applyDiscount();
    public void getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    double totalPrice;

    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    void calculateTotalPrice() {
        totalPrice = getPrice() * getQuantity();
        System.out.println("Total Price for Veg Item: " + totalPrice);
    }

    public void applyDiscount() {
        totalPrice = totalPrice - 20;
        System.out.println("Discount applied on Veg Item.");
    }

    public void getDiscountDetails() {
        System.out.println("₹20 discount applied. Final Price: " + totalPrice);
    }
}

class NonVegItem extends FoodItem implements Discountable {
    double totalPrice;

    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    void calculateTotalPrice() {
        totalPrice = (getPrice() * getQuantity()) + 50;
        System.out.println("Total Price for Non-Veg Item (with extra charges): " + totalPrice);
    }

    public void applyDiscount() {
        totalPrice = totalPrice - 30;
        System.out.println("Discount applied on Non-Veg Item.");
    }

    public void getDiscountDetails() {
        System.out.println("₹30 discount applied. Final Price: " + totalPrice);
    }
}

public class FoodDelivery{
    public static void main(String[] args) {
        FoodItem f1 = new VegItem("Paneer Butter Masala", 200, 2);
        FoodItem f2 = new NonVegItem("Chicken Biryani", 300, 1);

        f1.getItemDetails();
        f1.calculateTotalPrice();
        ((Discountable)f1).applyDiscount();
        ((Discountable)f1).getDiscountDetails();

        System.out.println();

        f2.getItemDetails();
        f2.calculateTotalPrice();
        ((Discountable)f2).applyDiscount();
        ((Discountable)f2).getDiscountDetails();
    }
}
