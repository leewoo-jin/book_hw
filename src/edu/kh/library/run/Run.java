package edu.kh.library.run;

import edu.kh.library.model.service.BookService;

public class Run {
	
	public static void main (String[] args) {
	

		BookService service = new BookService();
	
		service.displayMenu();
	
	}

}
