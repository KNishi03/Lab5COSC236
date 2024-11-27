package lab5.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import lab5.Library;
import lab5.PaperBook;
import lab5.EBook;
import lab5.AudioBook;
import lab5.Member;
import lab5.BorrowingService;
import lab5.BorrowingServiceAPI;

public class TestBorrowingService {

    @Test
    public void testBorrowAndReturnPaperBook() {
        Library library = new Library();
        PaperBook book = new PaperBook("Dune");
        library.addBook(book);

        Member member = new Member("Alice");
        library.addMember(member);

        BorrowingServiceAPI borrowingService = new BorrowingService();

        // Borrow book
        assertTrue(borrowingService.borrowBook(member, book));
        assertFalse(book.getIsAvailable());
        assertEquals(1, member.getBorrowedBooks().size());

        // Return book
        assertTrue(borrowingService.returnBook(member, book));
        assertTrue(book.getIsAvailable());
        assertEquals(0, member.getBorrowedBooks().size());
    }

    @Test
    public void testBorrowAndReturnEBook() {
        Library library = new Library();
        EBook ebook = new EBook("Digital Fortress");
        library.addBook(ebook);

        Member member = new Member("Bob");
        library.addMember(member);

        BorrowingServiceAPI borrowingService = new BorrowingService();

        // Borrow eBook
        assertTrue(borrowingService.borrowBook(member, ebook));
        assertFalse(ebook.getIsAvailable());
        assertEquals(1, member.getBorrowedBooks().size());

        // Return eBook
        assertTrue(borrowingService.returnBook(member, ebook));
        assertTrue(ebook.getIsAvailable());
        assertEquals(0, member.getBorrowedBooks().size());
    }

    @Test
    public void testBorrowAndReturnAudioBook() {
        Library library = new Library();
        AudioBook audiobook = new AudioBook("The Alchemist");
        library.addBook(audiobook);

        Member member = new Member("Charlie");
        library.addMember(member);

        BorrowingServiceAPI borrowingService = new BorrowingService();

        // Borrow audio book
        assertTrue(borrowingService.borrowBook(member, audiobook));
        assertFalse(audiobook.getIsAvailable());
        assertEquals(1, member.getBorrowedBooks().size());

        // Return audio book
        assertTrue(borrowingService.returnBook(member, audiobook));
        assertTrue(audiobook.getIsAvailable());
        assertEquals(0, member.getBorrowedBooks().size());
    }
}
