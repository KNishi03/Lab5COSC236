package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency

	public Member(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Member: " + name;
	}

	public void borrowBook(Book book) {
		BorrowingService borrowingService = new BorrowingService();
		boolean success = borrowingService.borrowBook(this, book);
		if (success) {
			{ System.out.println(name + " borrowed " +
			} else {
				System.out.println(name + " could not borrow " + book.getTitle());
			}
		}
	}

	public void returnBook(Book book) {
		BorrowingService borrowingService = new BorrowingService();
		boolean success = borrowingService.borrowBook(this, book);
		if (success) {
			System.out.println(name + " returned " + book.getTitle());
		}else {
			System.out.println(name + " could not return " + book.getTitle());
		}
	}


	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}

	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}

	public void returnAllBooks() {
		Iterator<Book> bookIterator = borrowedBooks.iterator();
		while (bookIterator.hasNext()) {
			Book book = bookIterator.next();
			book.setIsAvailable(true);
		}
		borrowedBooks.clear(); // clear array of borrowed books
	}
}
