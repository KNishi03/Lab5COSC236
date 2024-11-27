package lab5;

public class BorrowingService implements BorrowingServiceAPI {

    @Override
    public boolean borrowBook(Member member, Book book) {
        if (book != null && book.getIsAvailable() && !member.getBorrowedBooks().contains(book)) {
            member.getBorrowedBooks().add(book);
            book.setIsAvailable(false);
            System.out.println("Borrowing book: " + book.getTitle());
            return true;
        } else {
            System.out.println("Cannot borrow book: " + book.getTitle());
            return false;
        }
    }

    @Override
    public boolean returnBook(Member member, Book book) {
        if (book != null && member.getBorrowedBooks().contains(book)) {
            member.getBorrowedBooks().remove(book);
            book.setIsAvailable(true);
            System.out.println("Returning book: " + book.getTitle());
            return true;
        } else {
            System.out.println("Cannot return book: " + book.getTitle());
            return false;
        }
    }
}
