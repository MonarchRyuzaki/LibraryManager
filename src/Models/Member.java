package Models;

import java.util.List;
import java.util.UUID;

public class Member {
    private final UUID memberId;
    private String memberName;
    private List<Book> borrowedBooks;

    public Member(String memberName, List<Book> borrowedBooks) {
        this.memberId = UUID.randomUUID();
        this.memberName = memberName;
        this.borrowedBooks = borrowedBooks;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
