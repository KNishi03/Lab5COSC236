public class PaperBookFactory extends BookFactory{
	public Book createBook(String title){
		retturn new PaperBook(title);
	}
}
