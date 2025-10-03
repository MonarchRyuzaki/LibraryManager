package Services;

import Models.Book;
import Models.BookStatus;

import java.util.ArrayList;
import java.util.List;

public class BookKeepingService {
    private final List<Book> bookList = new ArrayList<>();
    private static BookKeepingService bookManager;
    private BookKeepingService() {}
    public synchronized BookKeepingService getBookManager() {
        if (bookManager == null) {
            bookManager = new BookKeepingService();
        }
        return bookManager;
    }
    public List<Book> getBookList() {
        return bookList;
    }
    public void addBook(Book newBook) {
        bookList.add(newBook);
    }
    public List<Book> getBookListByAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        return bookList.stream().filter(book -> book.getAuthor().equals(author)).toList();
    }
    public List<Book> getBookListByTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        return bookList.stream().filter(book -> book.getTitle().equals(title)).toList();
    }
    public List<Book> getBookListByISBN(String isbn) {
        if (isbn == null) {
            throw new IllegalArgumentException("ISBN cannot be null");
        }
        return bookList.stream().filter(book -> book.getIsbn().equals(isbn)).toList();
    }
    public List<Book> getBookListByStatus(BookStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        return bookList.stream().filter(book -> book.getStatus().equals(status)).toList();
    }
}
