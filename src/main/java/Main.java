import model.Book;
import model.Member;
import service.LibraryService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        List<String> services = Arrays.asList(
                "Add Book",
                "Register Member",
                "Borrow Book",
                "Return Book",
                "View Available Books",
                "View Borrowed Books by Member",
                "Exit"
        );

        while (true) {
            System.out.println("\n===== Library Menu =====");
            for (int i = 0; i < services.size(); i++) {
                System.out.println((i + 1) + ". " + services.get(i));
            }
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookId = scanner.nextLine();
                    Book book = new Book(bookId, title, true, author);
                    libraryService.addBook(book);
                    System.out.println("Book added.");
                    break;

                case "2":
                    System.out.print("Enter member name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member ID: ");
                    String memberId = scanner.nextLine();
                    Member member = new Member(memberId, name);
                    libraryService.registerMember(member);
                    System.out.println("Member registered.");
                    break;

                case "3":
                    System.out.print("Enter member ID: ");
                    String borrowMemberId = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String borrowBookId = scanner.nextLine();
                    libraryService.borrowBook(borrowMemberId, borrowBookId);
                    break;

                case "4":
                    System.out.print("Enter member ID: ");
                    String returnMemberId = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String returnBookId = scanner.nextLine();
                    libraryService.returnBook(returnMemberId, returnBookId);
                    break;

                case "5":
                    libraryService.listAvailableBooks();
                    break;

                case "6":
                    System.out.print("Enter member ID: ");
                    String listMemberId = scanner.nextLine();
                    libraryService.listBorrowedBooksByMember(listMemberId);
                    break;

                case "7":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}


