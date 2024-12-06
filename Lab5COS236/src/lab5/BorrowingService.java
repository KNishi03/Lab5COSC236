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
    public boolean borrowBook(Member member, Book book) {
        if (member.getBorrowedItems().size() < borrowingLimit) {
            member.getBorrowedItems().add(book);
            System.out.println("Book borrowed successfully!");
            return true;
        }
        System.out.println("Borrowing limit reached.");
        return false;
    }

    @Override
    public boolean returnBook(Member member, Book book) {
        if (member.getBorrowedItems().remove(book)) {
            System.out.println("Book returned successfully!");
            return true;
        }
        System.out.println("Book not found in borrowed items.");
        return false;
    }
}