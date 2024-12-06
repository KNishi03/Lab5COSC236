package lab5;

public class LibrarianController {
	
	Library library; // Library dependency

	private final BorrowingService borrowingService;
	public LibrarianController( ) {
		this.library = new Library(); // Constructor injection
	}
	public Library getLibrary() {
		return this.library;
	}
	public void showBooks() {
		library.showBooks();
	}
	public void showMembers() {
		library.showMembers();
	}
	public void addPaperBook(String title) {
		library.addBook(new PaperBook(title));  // Book class constructor dependency
	}
	public void addEBook(String title) {
		library.addBook(new EBook(title)); 
	}
	
	public void addAudioBook(String title) { 
		library.addBook(new AudioBook(title)); 
	}
	public void addMember(String name) {
		library.addMember(new Member(name)); // Member class constructor dependency
	}
	public void removeBook(String title) {
		library.removeBook(title); // remove 
	}
	public void removeMember(String name) {
		library.removeMember(name);
	}
	public LibrarianController(Library library) {
		this.library = library;
		this.borrowingService = BorrowingService.getInstance();
	}
	public void addMember(String name) {
		library.addMember(new Member(name, borrowingService));
	}
	public void showMember(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			System.out.println(member);
		else 
			System.out.println("Member " + name + " not found.");
	}
	public void showBook(String title) {
		Book book = library.findBookByTitle(title);
		if (book != null)
			System.out.println(book);
		else 
			System.out.println("Book " + title + " not found.");
	}
	public void showMemberBooks(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			member.listBorrowedBooks();
		else 
			System.out.println("Member " + name + " not found.");
	}
	
	public void borrowBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title);  // use library for search
		if (book != null && member != null)
			member.borrowBook(book); // member borrows a book, not library 
		else 	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
	
	public void returnBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title); // use library for search 
		if (book != null && member != null)
			member.returnBook(book); // members returns book. 
		else  	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
	public void addBook(BookFactory bFactory, String title){
		library.addBook(bFactory.createBook(title));
	}
	public void addEBook(String title){
		EBookFactory eBookFactory= new EBookFactory();
		library.addBook(eBookFactory.createBook(title));
	}
	public void addAudioBook(String title){
		AudioBookFactory audioBookFactory= new AudioBookFactory();
		library.addBook(audioBookFactory.createBook(title));
	}
	public void addPaperBook(String title){
		PaperBookFactory paperBookFactory= new PaperBookFactory();
		library.addBook(paperBookFactory.createBook(title));
	}
}
