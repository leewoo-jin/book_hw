package edu.kh.library.model.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.library.model.vo.Book;



public class BookService {
	
	FileWriter fw = null;
	BufferedWriter bw = null;
	
	private Scanner sc = new Scanner(System.in);

	private ArrayList<Book> library = new ArrayList<Book>();
	
	
	public BookService() {
		library.add(new Book(1111, "세이노의 가르침", "세이노", 6480, "데이원"));
		library.add(new Book(2222, "문과남자의 과학공부", "유시민", 15750, "돌베개"));
		library.add(new Book(3333, "역행자", "자청", 17550, "웅진지식하우스"));
		library.add(new Book(4444, "꿀벌의 예언", "베르나르 베르베르", 15120, "열린책들"));
		library.add(new Book(5555, "도둑맞은 집중력", "요한 하리", 16920, "어크로스"));
	}
	

	public void displayMenu() {
		
	
		try {//전체 오류를 한번에 잡아줌
		
			int menu = 0;
			do{
			
				System.out.println("==도서 목록 프로그램==");
				System.out.println("1. 도서 등록");
				System.out.println("2. 도서 조회");
				System.out.println("3. 도서 수정");
				System.out.println("4. 도서 삭제");
				System.out.println("5. 즐겨찾기 추가");
				System.out.println("6. 즐겨찾기 삭제");
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴를 입력하세요 : ");
				menu = sc.nextInt(); //메뉴 받아서 반복
				sc.nextLine();
				
				switch(menu) {
				case 1 : System.out.println(addBook()); break;
				case 2 : bookList(); break;
				case 3 : System.out.println(editBook()); break;
				case 4 : System.out.println(deleteBook()); break;
				case 5 : System.out.println(addFavorite());  
						 break;
				case 6 : System.out.println(deleteFavorite()); break;
				case 0 : System.out.println("종료되었습니다."); break;
				default : System.out.println("잘못 입력하셨습니다.메뉴에 있는 번호를 입력해주세요"); break;
				}
			
			}while(menu!=0);
		}catch(InputMismatchException e) {
			System.out.println("잘못 입력하셨습니다. 프로그램 재실행합니다.");
			sc.nextLine();
			displayMenu();
			
		}catch(Exception e) {
			System.out.println("잘못 입력하셨습니다. 프로그램 재실행합니다.");
			sc.nextLine();
			displayMenu();
		}
	}
	
	public String addBook() {
		
		//등록 메뉴 만들기
		System.out.println("=====도서 등록=====");
		
		//등록 순 번호 부여
		System.out.print("도서 번호 : ");
		int bookNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("도서 제목 : ");
		String name = sc.nextLine();
		
		System.out.print("도서 저자 : ");
		String writer = sc.nextLine();
		
		System.out.print("도서 가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("도서 출판사 : ");
		String publisher = sc.nextLine();
		
		Book newBook = new Book(bookNum, name, writer, price, publisher);
		library.add(newBook);
		
		return "등록 완료" ;
		
	}
	
	public void bookList() {
		
		
		if(library.size() != 0) {
			
			for(Book temp: library) {
				System.out.println( temp.toString());
			}
		}else {
			System.out.println("등록된 도서가 없습니다. 도서를 등록해주세요");
			displayMenu();
		}
		
		// 전체 조회 
		
	}
	
	public String editBook() {
		
		bookList();
		
		int editMenu = 0;

		System.out.println("=====도서 수정=====");
	
		System.out.print ("수정할 도서 번호를 입력하세요 : ");
		int libraryNum = sc.nextInt();
	
		
			// 등록넘버를 받고 그 번호에 일치하면 수정 시작
		boolean flag = true;	
		
		for(Book temp : library) {
			
			if(libraryNum == temp.getBookNum()){
				flag = false; // 일치하는 도서번호가 있다는 것
				
				System.out.println("1. 도서명");
				System.out.println("2. 도서 저자");
				System.out.println("3. 도서 가격");
				System.out.println("4. 도서 출판사");
				System.out.println("0. 수정 종료");
				System.out.print("어떤 정보를 수정하시겠습니까? ");
				
				// 번호를 받고 번호에 맞는 값 수정
				editMenu = sc.nextInt();
				sc.nextLine();
				
				switch(editMenu) {
				
				case 1: System.out.println("=====도서명 수정====");
				System.out.print("수정할 도서명을 입력하세요 : ");
				String name = sc.nextLine();
				temp.setName(name);
				editMenu = 0;
				break;
				
				case 2: System.out.println("=====도서 저자 수정====="); 
				System.out.print("수정할 저자를 입력하세요 : ");
				String writer = sc.nextLine();
				temp.setWriter(writer);
				editMenu = 0;
				break;
				
				case 3: System.out.println("=====도서 가격 수정====="); 
				System.out.print("수정할 가격을 입력하세요 : ");
				int price = sc.nextInt();
				temp.setPrice(price);
				editMenu = 0;
				break;
				
				case 4: System.out.println("=====도서 출판사 수정====="); 
				System.out.print("수정할 저자를 입력하세요 : ");
				String publisher = sc.nextLine();
				temp.setPublisher(publisher);
				editMenu = 0;
				break;
				
				case 0: System.out.println("종료합니다"); break;
				
				default: System.out.println("잘못 입력하셨습니다.");  break;
	
				}
			}
		}
		
		if(flag) {
			return "일치하는 도서번호가 없습니다";
		}

		
		return "수정 완료" ;
		
	}
	
	public String deleteBook() {
		System.out.println("=====도서 삭제=====");
		bookList(); // 등록된 도서를 보여줌
		
		System.out.print("삭제할 도서의 번호를 입력하세요 : ");
		int deleteNum = sc.nextInt();
		sc.nextLine();
		
		for(Book temp : library ) {
			
			if(temp.getBookNum() == deleteNum) {
				int index = library.indexOf(temp);
				System.out.println("정말로 삭제하시겠습니까? (Y/N)");
				
				char yesorno = sc.next().toUpperCase().charAt(0);
				
				//삭제 확인용 질문 생성
				
				if(yesorno == 'Y') {
					library.remove(index);
					break;
					
				}else {
					return "삭제를 진행하지 않습니다.";
				}
				
			}
		}
		return "삭제 완료";
	}

	public String addFavorite() {

		bookList();
		System.out.println("=====즐겨 찾기 등록=====");
		
		System.out.print("즐겨찾기 등록할 도서 번호를 입력하세요 : ");
		int input = sc.nextInt();
		// 즐겨찾기 등록
		
		boolean flag = false;
			
		for(int i = 0; i< library.size(); i++) {
			if(library.get(i).getBookNum() == input) {
				library.get(i).setFav(true);
				flag = true;
			}
		}

		if (!flag) {
			return "찾는 번호가 없습니다.";
		}else {
			return "등록 성공";
		}
	}




	public String deleteFavorite() {
		
		
		
		boolean exist = false;
		
		System.out.println("즐겨찾기 등록된 도서");
		for(Book temp : library) {
			if(temp.isFav()==true) {
				System.out.println(temp.favorite());
				exist= true;
			}
			
		}
		
		if(!exist) {
			return "즐겨찾기에 등록된 도서가 없습니다.";
		}

		// 즐겨찾기 등록된 도서 확인
		
		System.out.print("삭제할 도서 번호를 입력하세요 : ");
		int deleteNum = sc.nextInt();
		
		boolean flag = false;
		// 없을 때 확인
		
		for(int i = 0; i< library.size(); i++) {
			if(library.get(i).getBookNum() == deleteNum) {
				library.get(i).setFav(false);
				flag = true;
			}
		}
		
		if (!flag) {
			return "찾는 번호가 없습니다.";
		}else {
			return "삭제 성공";
		}
	}

	
}

