package lab5;

public class BorrowingService implements BorrowingServiceAPI {
    private static volatile BorrowingService instance;
    private final int borrowingLimit;

    private BorrowingService() {
        borrowingLimit = 3;
    }
    public static BorrowingService getInstance() {
        if (instance == null) {
            synchronized (BorrowingService.class) {
                if (instance == null) {
                    instance = new BorrowingService();
                }
            }
        }
        return instance;
    }

    @Override
    public BorrowingBookResult borrowBook(Member member, Book book) {
        if (member.getBorrowedItems().size() < borrowingLimit) {
            member.getBorrowedItems().add(book);
            return new BorrowingBookResult(true, "Book borrowed successfully!");
        }
        return new BorrowingBookResult(false, "Borrowing limit reached.");
    }

    @Override
    public BorrowingBookResult returnBook(Member member, Book book) {
        if (member.getBorrowedItems().remove(book)) {
            return new BorrowingBookResult(true, "Book returned successfully!");
        }
        return new BorrowingBookResult(false, "Book not found in borrowed items.");
    }
}