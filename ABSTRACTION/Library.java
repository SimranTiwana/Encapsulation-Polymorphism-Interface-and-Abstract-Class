abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    private String borrower; // sensitive info

    LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrower = null; // initially not borrowed
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Encapsulation: borrower details
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBorrower() {
        return borrower;
    }

    abstract void getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

interface Reservable {
    public void reserveItem();
    public void checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    boolean available = true;

    Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    void getLoanDuration() {
        System.out.println("Loan Duration for Book: 14 days");
    }

    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book already reserved.");
        }
    }

    public void checkAvailability() {
        if (available) {
            System.out.println("Book is available.");
        } else {
            System.out.println("Book is not available.");
        }
    }
}

class Magazine extends LibraryItem implements Reservable {
    boolean available = true;

    Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    void getLoanDuration() {
        System.out.println("Loan Duration for Magazine: 7 days");
    }

    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine already reserved.");
        }
    }

    public void checkAvailability() {
        if (available) {
            System.out.println("Magazine is available.");
        } else {
            System.out.println("Magazine is not available.");
        }
    }
}

class DVD extends LibraryItem implements Reservable {
    boolean available = true;

    DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    void getLoanDuration() {
        System.out.println("Loan Duration for DVD: 3 days");
    }

    public void reserveItem() {
        if (available) {
            available = false;
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD already reserved.");
        }
    }

    public void checkAvailability() {
        if (available) {
            System.out.println("DVD is available.");
        } else {
            System.out.println("DVD is not available.");
        }
    }
}

public class Library {
    public static void main(String[] args) {
        LibraryItem item1 = new Book(101, "Java Programming", "James Gosling");
        LibraryItem item2 = new Magazine(202, "Tech Monthly", "Editorial Team");
        LibraryItem item3 = new DVD(303, "Inception", "Christopher Nolan");

        item1.getItemDetails();
        item1.getLoanDuration();
        ((Reservable)item1).checkAvailability();
        ((Reservable)item1).reserveItem();
        ((Reservable)item1).checkAvailability();

        System.out.println();

        item2.getItemDetails();
        item2.getLoanDuration();
        ((Reservable)item2).checkAvailability();
        ((Reservable)item2).reserveItem();

        System.out.println();

        item3.getItemDetails();
        item3.getLoanDuration();
        ((Reservable)item3).reserveItem();
    }
}
