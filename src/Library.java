import Models.Book;
import Models.Member;
import Services.BookIssueService;
import Services.BookKeepingService;
import Services.MemberManagementService;

import java.util.List;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        System.out.println("LIBRARY MANAGER");
        System.out.println("1. Add a Book");
        System.out.println("2. View all Book");
        System.out.println("3. Search Book by title");
        System.out.println("4. Register a new member");
        System.out.println("5. View all Members");
        System.out.println("6. Issue Book to a member");
        System.out.println("7. Return a Book");
        System.out.println("8. View Books");
        Scanner sc = new Scanner(System.in);
        BookKeepingService bookKeepingService = BookKeepingService.getInstance();
        MemberManagementService memberManagementService = MemberManagementService.getInstance();
        BookIssueService bookIssueService = BookIssueService.getInstance();
        boolean run = true;
        while (run) {
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter ISBN");
                    String isbn = sc.nextLine();
                    System.out.println("Enter title");
                    String title = sc.nextLine();
                    System.out.println("Enter author");
                    String author = sc.nextLine();
                    bookKeepingService.addBook(new Book(isbn, title, author));
                    break;
                case 2:
                    List<Book> books = bookKeepingService.getBookList();
                    for (Book book : books) {
                        System.out.println(book);
                    }
                    break;
                case 3:
                    System.out.println("Enter title");
                    title = sc.nextLine();
                    List<Book> searchResults = bookKeepingService.getBookListByTitle(title);
                    for (Book book : searchResults) {
                        System.out.println(book);
                    }
                    break;
                case 4:
                    System.out.println("Enter name");
                    String name = sc.nextLine();
                    memberManagementService.addMember(new Member(name));
                    break;
                case 5:
                    List<Member> members = memberManagementService.getMemberList();
                    for (Member member : members) {
                        System.out.println(member);
                    }
                    break;
                case 6:
                    System.out.println("Enter isbn");
                    isbn = sc.nextLine();
                    System.out.println("Enter title");
                    title = sc.nextLine();
                    System.out.println("Enter author");
                    author = sc.nextLine();
                    System.out.println("Enter name");
                    String memberName = sc.nextLine();
                    bookIssueService.issueBookToMember(new Book(isbn, title, author), new Member(memberName));
                    break;
                case 7:
                    System.out.println("Enter isbn");
                    isbn = sc.nextLine();
                    System.out.println("Enter title");
                    title = sc.nextLine();
                    System.out.println("Enter author");
                    author = sc.nextLine();
                    System.out.println("Enter name");
                    memberName = sc.nextLine();
                    bookIssueService.returnBookFromMember(new Book(isbn, title, author), new Member(memberName));
                case 8:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again!!");
            }
        }
    }
}
