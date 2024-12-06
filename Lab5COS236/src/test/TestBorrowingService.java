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
        BorrowingBookResult borrowResult = borrowingService.borrowBook(member, book);
        assertTrue(borrowResult.isSuccessful());
        //assertTrue(borrowingService.borrowBook(member, book));
        assertFalse(book.getIsAvailable());
        assertEquals(1, member.getBorrowedBooks().size());

        // Return book
        BorrowingBookResult returnResult = borrowingService.returnBook(member, book);
        assertTrue(returnResult.isSuccessful());
        //assertTrue(borrowingService.returnBook(member, book));
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
        BorrowingBookResult borrowResult = borrowingService.borrowBook(member, ebook);
        assertTrue(borrowResult.isSuccessful());
        //assertTrue(borrowingService.borrowBook(member, ebook));
        assertFalse(ebook.getIsAvailable());
        assertEquals(1, member.getBorrowedBooks().size());

        // Return eBook
        BorrowingBookResult returnResult = borrowingService.returnBook(member, ebook);
        assertTrue(returnResult.isSuccessful());
        //assertTrue(borrowingService.returnBook(member, ebook));
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
        BorrowingBookResult borrowResult = borrowingService.borrowBook(member, audiobook);
        assertTrue(borrowResult.isSuccessful());
        //assertTrue(borrowingService.borrowBook(member, audiobook));
        assertFalse(audiobook.getIsAvailable());
        assertEquals(1, member.getBorrowedBooks().size());

        // Return audio book
        BorrowingBookResult returnResult = borrowingService.returnBook(member, audiobook);
        assertTrue(returnResult.isSuccessful());
        //assertTrue(borrowingService.returnBook(member, audiobook));
        assertTrue(audiobook.getIsAvailable());
        assertEquals(0, member.getBorrowedBooks().size());
    }
    
    @Test
    public void testBorrowingLimit() {
    	Library library = new Library();
    	PaperBook book1 = new PaperBook("Dune");
    	PaperBook book2 = new PaperBook("Wild");
    	PaperBook book3 = new PaperBook ("Verity");
    	PaperBook book4 = new PaperBook("Twilight");
    	library.addBook(book1);
    	library.addBook(book2);
    	library.addBook(book3);
    	library.addBook(book4);
    	
    	Member member = new Member("Charlie");
        library.addMember(member);
        
        BorrowingServiceAPI borrowingService = BorrowingService.getInstance();
        
        assertTrue(borrowingService.borrowBook(member, book1).isSuccess());
        assertTrue(borrowingService.borrowBook(member, book2).isSuccess());
        assertTrue(borrowingService.borrowBook(member, book3).isSuccess());
        BorrowingBookResult borrowResult = borrowingService.borrowBook(member, book4);
        assertFalse(borrowResult.isSuccess());
        assertEquals("Borrowing limit reached.", borrowingResult.getBorrowingMessage());
    }
}
