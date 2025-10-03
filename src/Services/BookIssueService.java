package Services;

import Models.Book;
import Models.BookStatus;
import Models.Member;

public class BookIssueService {

    private static BookIssueService instance;
    private BookIssueService() {}
    public synchronized static BookIssueService getInstance() {
        if (instance == null) {
            instance = new BookIssueService();
        }
        return instance;
    }

    public void issueBookToMember(Book book, Member member) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        book.setIssued(member.getMemberId());
        book.setStatus(BookStatus.ISSUED);
        member.setBorrowedBook(book);
    }

    public void returnBookFromMember(Book book, Member member) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        book.setIssued(null);
        book.setStatus(BookStatus.AVAILABLE);
        member.removeBorrowedBook(book);
    }
}
