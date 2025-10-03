package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Member {
    private final UUID memberId;
    private String memberName;
    private List<Book> borrowedBooks;

    public Member(String memberName) {
        this.memberId = UUID.randomUUID();
        this.memberName = memberName;
        this.borrowedBooks = new ArrayList<>();
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
