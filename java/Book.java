package activities;

//Abstract Class
abstract class Book {
	String title;
	abstract void setTitle(String str);
	String getTitle() {
		return title;
		};
}
class MyBook extends Book{
	public void setTitle(String str) {
		title = str;
	}
}