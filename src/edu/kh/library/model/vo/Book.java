package edu.kh.library.model.vo;

public class Book {
	
	private String name;
	private String writer;
	private int price;
	private String publisher;
	private int bookNum;
	private boolean fav;
	
	public Book() {
		this.fav = false;
	}
	
	public Book(int bookNum, String name, String writer, int price, String publisher) {
		this.bookNum=bookNum;
		this.name = name;
		this.writer = writer;
		this.price = price;
		this.publisher = publisher;
		this.fav = false;
	}
	
	
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public boolean isFav() {
		return fav;
	}
	public void setFav(boolean fav) {
		this.fav = fav;
	}
	

	public String toString() {
		return bookNum + "번 도서 : [도서제목 : " + name + " / 도서저자 : " + writer + " / 도서가격 : " + price + "원 / 출판사 : " + publisher + "]";		
	}
	
	public String favorite() {
		return bookNum + "번 도서 : [도서제목 : " +  name + "/ 도서 저자 : " +  writer + "]\n";
		
	}
	
	
	
}
