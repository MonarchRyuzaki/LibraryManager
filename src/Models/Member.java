package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public void setBorrowedBook(Book borrowedBook) {
        this.borrowedBooks.add(borrowedBook);
    }

    public void removeBorrowedBook(Book book) {
        this.borrowedBooks = this.borrowedBooks.stream().filter(b -> !Objects.equals(b.getIsbn(), book.getIsbn())).toList();
    }

    @Override
    public String toString() {
        StringBuilder borrowedBooksString = new StringBuilder();
        for (Book book : borrowedBooks) {
            borrowedBooksString.append(book);
        }
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", borrowedBooks=" + borrowedBooksString +
                '}';
    }
}
