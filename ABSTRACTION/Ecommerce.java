/*abstract class Product{
   private int id;
   private String name;
  private double price;

   Product(int id, String name, double price){
    this.id = id;
    this.name = name;
    this.price = price;
    System.out.println(" THE ID OF THE PRODUCT IS: "+ id);
    System.out.println(" THE NAME OF THE PRODUCT IS: "+ name);
    System.out.println(" THE PRICE OF THE PRODUCT IS: "+price);
   }

   abstract calculateDiscount();  
   public getinfo(){
    return name;
   }

   public getprice(){
    return price;
   }

   public getId(){
    return id;}

    public setPrice(double price){
        this.price = price;
   }

}
class Electronics extends Product implements Taxable{
    String elecName;
    int ElecId;
    double ElecPrice;
    Electronics(String elecName, int ElecId, double ElecPrice){
        super(int id, String name, double price);
        System.out.println(" THE NAME OF ELECTRONICS IS: "+elecName);
        System.out.println(" THE ID OF THE PRODUCT IS: "+ElecId);
        System.out.println(" THE PRICE OF THE PRODUCT IS: "+ Elecprice);
    }
    double calculateDiscount(){
        return getprice() * .25;
    }
    double tax(){
        return getprice() * .10;
    }


    
}
class Clothing extends Product implements Taxable{
    String ClothName;
    int noOfProducts;
    double price;
    Clothing(String ClothName, int noOfProducts, double price){
        super(int id, String name, double price);
        System.out.println(" THE NAME OF THE CLOTHING PIECE IS: "+ ClothName);
        System.out.println(" THE NO OF PRODUCTS IN THE ORDER ARE: "+ noOfProducts);
        System.out.println(" THE PRICE OF THE PRODUCT IS: "+ price);
    }
}
class Groceries extends Product implements Taxable{
    double price;
    String Variety;
    Groceries(double price, String Variety)
    {
        super(int id, String name, double price);
        System.out.println(" THE LIST OF GROCERY INCLUDES: "+Variety)
        System.out.println(" THE PRICE OF THE ENTIRE GROCERIES IS: "+price);
    
    }
}

interface Taxable{
    double calculateTax();
    String getTaxDetails();
}
public class Ecommerce{
    public static void main(String[] args){

    }
}*/

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product implements Taxable {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    abstract double calculateDiscount();
}
class Electronics extends Product {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.15;
    }

    public String getTaxDetails() {
        return "Electronics Tax: 15%";
    }
}

class Clothing extends Product {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.05;
    }

    public double calculateTax() {
        return getPrice() * 0.10;
    }

    public String getTaxDetails() {
        return "Clothing Tax: 10%";
    }
}

class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    double calculateDiscount() {
        return getPrice() * 0.02;
    }

    public double calculateTax() {
        return getPrice() * 0.05;
    }

    public String getTaxDetails() {
        return "Groceries Tax: 5%";
    }
}

public class Ecommerce {
    public static void printFinalPrice(Product p) {
        double price = p.getPrice();
        double discount = p.calculateDiscount();
        double tax = p.calculateTax();

        double finalPrice = price + tax - discount;

        System.out.println("Product: " + p.getName());
        System.out.println("Price: " + price);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println("Final Price: " + finalPrice);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Product p1 = new Electronics(101, "Laptop", 50000);
        Product p2 = new Clothing(102, "T-Shirt", 1000);
        Product p3 = new Groceries(103, "Rice", 200);

        Product[] products = {p1, p2, p3};

        for (Product p : products) {
            printFinalPrice(p);
        }
    }
}
