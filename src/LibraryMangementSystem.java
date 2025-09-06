import java.util.*;

class Book {
    String title;
    String author;
    String isbn;
    int quantity;

    Book(String title, String author, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
    }
}

class Member {
    int id;
    String name;
    List<String> borrowedBooks = new ArrayList<>();

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class LibraryMangementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Book> books = new HashMap<>();
        Map<Integer, Member> members = new HashMap<>();

        while (true) {
            System.out.println("\n📚 Library Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Inventory");
            System.out.println("6. View Member History");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();
                    books.put(isbn, new Book(title, author, isbn, qty));
                    System.out.println("✅ Book added.");
                    break;

                case 2:
                    System.out.print("Enter member ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter member name: ");
                    String name = sc.nextLine();
                    members.put(id, new Member(id, name));
                    System.out.println("✅ Member registered.");
                    break;

                case 3:
                    System.out.print("Enter member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter ISBN of book to issue: ");
                    String issueIsbn = sc.nextLine();
                    if (members.containsKey(memberId) && books.containsKey(issueIsbn)) {
                        Book b = books.get(issueIsbn);
                        if (b.quantity > 0) {
                            b.quantity--;
                            members.get(memberId).borrowedBooks.add(issueIsbn);
                            System.out.println("📖 Book issued to " + members.get(memberId).name);
                        } else {
                            System.out.println("❌ Book out of stock.");
                        }
                    } else {
                        System.out.println("❌ Invalid member ID or ISBN.");
                    }
                    break;

                case 4:
                    System.out.print("Enter member ID: ");
                    int returnId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter ISBN of book to return: ");
                    String returnIsbn = sc.nextLine();
                    if (members.containsKey(returnId) && books.containsKey(returnIsbn)) {
                        Member m = members.get(returnId);
                        if (m.borrowedBooks.contains(returnIsbn)) {
                            m.borrowedBooks.remove(returnIsbn);
                            books.get(returnIsbn).quantity++;
                            System.out.println("✅ Book returned.");
                        } else {
                            System.out.println("❌ Member did not borrow this book.");
                        }
                    } else {
                        System.out.println("❌ Invalid member ID or ISBN.");
                    }
                    break;

                case 5:
                    System.out.println("\n📚 Book Inventory:");
                    for (Book b : books.values()) {
                        System.out.println("Title: " + b.title + ", Author: " + b.author +
                                ", ISBN: " + b.isbn + ", Quantity: " + b.quantity);
                    }
                    break;

                case 6:
                    System.out.print("Enter member ID: ");
                    int viewId = sc.nextInt();
                    sc.nextLine();
                    if (members.containsKey(viewId)) {
                        Member m = members.get(viewId);
                        System.out.println("👤 Member Name: " + m.name);
                        System.out.println("📖 Borrowed Books:");
                        for (String borrowedIsbn : m.borrowedBooks) {
                            Book b = books.get(borrowedIsbn);
                            System.out.println("  " + b.title + " (ISBN: " + b.isbn + ")");
                        }
                    } else {
                        System.out.println("❌ Member not found.");
                    }
                    break;

                case 7:
                    System.out.println("👋 Exiting Library System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}


