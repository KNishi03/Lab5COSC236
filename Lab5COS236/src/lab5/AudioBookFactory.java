public class AudioBookFactory extends BookFactory{
	public Book createBook(String title){
		retturn new AudioBook(title);
	}
}
