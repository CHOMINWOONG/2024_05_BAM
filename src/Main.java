import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Main {
	
	static List<Article> articles = new ArrayList<>();

	static int lastArticleId = 1;

	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
		
		makeTestData();
		
		
//		데이터타입을 받을 함수 Scanner
		Scanner sc = new Scanner(System.in);
			
		
		
		while(true) {
			
			
			
			System.out.printf("명령어) ");
//			Trim 공백을 제거해주는 함수
//			nextLine은 값을 입력하게 받을 함수
			String cmd = sc.nextLine().trim();
			
			if (cmd.equals("exit")) {
				break;
			}
			
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");

//				Continue 만나면 아래 조건을 보지않고 다시 위로 올라간다.
				continue;
			}
			
			if (cmd.equals("article list")) {
				
				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다.");
					
					continue;
				} 
				
				if (articles.size() != 0) {
					System.out.println("번호  |  제목  |  날짜  |  조회수");
					
					
					for (int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf("%d	|	%s	|	%s	|	%d\n", article.id, article.title, article.regDate, article.viewCnt);
					}
				}
				
			} else if (cmd.equals("article write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String text = sc.nextLine().trim();		
				
				
				int viewCnt = 0;
				
				articles.add(new Article(lastArticleId, Util.getDateStr(), title, text, viewCnt));
				
				System.out.println(lastArticleId + "번 게시물이 생성되었습니다.");
				lastArticleId++;
				continue;
				
			} else if (cmd.startsWith("article detail ")) {
			
				String[] cmdBits = cmd.split(" ");
																
				int id = Integer.parseInt(cmdBits[2]);
				
								
				Article foundArticle = null;
				
				
				
				
				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					} 
				}
					if (foundArticle == null) {
						System.out.println(id + "번 게시물이 존재하지 않습니다.");
						continue;
					}
					
					foundArticle.incrementViews();
					
					System.out.println("번호 : " + foundArticle.id);
					System.out.println("날짜 : " + foundArticle.regDate);
					System.out.println("제목 : " + foundArticle.title);
					System.out.println("내용 : " + foundArticle.text);
					System.out.println("조회수 : " + foundArticle.viewCnt);
					
					
			    
					
			} else if (cmd.startsWith("article delete ")) {
			String[] cmdBits = cmd.split(" ");

			int id = 0;
			
			try {
				id = Integer.parseInt(cmdBits[2]);
			} catch (NumberFormatException e) {
				System.out.println("명령어가 올바르지 않습니다.");
				continue;
			}

			Article foundArticle = null;

			for (Article article : articles) {
				if (article.id == id) {
					foundArticle = article;
					break;
				}
			}
			
//			int foundIndex = -1;
//			
//			int indexId = 0;
//			
//			for (Article article : articles) {
//				if (article.id == id) {
//					foundIndex = indexId;
//					break;
//				}
//				indexId++;
//			}
//			
//			for (int i = 0; i < articles.size(); i++) {
//				Article article = articles.get(i);
//				if (article.id == id) {
//					foundIndex = i;
//					break;
//				}
//			}
				if (foundArticle == null) {
						System.out.println(id + "번 게시물이 존재하지 않습니다.");
						continue;
					}				
				articles.remove(foundArticle);	
//				articles.remove(foundIndex);
				
				System.out.println(id + "번 게시물이 삭제되었습니다.");
																
			} else if (cmd.startsWith("article modify ")) {
				
				String[] cmdBits = cmd.split(" ");
				int id = 0;
				
				try {
					id = Integer.parseInt(cmdBits[2]);
				} catch (NumberFormatException e) {
					System.out.println("올바른 명령어가 아닙니다.");
					continue;
				}
				
				Article foundArticle = null;
				
				for (Article article : articles) {
					if (article.id == id) {
						foundArticle = article;
						break;
					}
				}
				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				
				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("수정할 내용 : ");
				String text = sc.nextLine().trim();
				
				foundArticle.title = title;
				foundArticle.text = text;
				
				System.out.println(id + "번 게시물이 수정되었습니다.");
			}
				
			
			
			
			else {
					System.out.println("존재하지 않는 명령어 입니다");
				}
				
				
			}
			
			sc.close();
			System.out.println("== 프로그램 끝 ==");
		}
	
	private static void makeTestData() {
		System.out.println("테스트용 게시글 데이터를 5개 생성했습니다");
		
		for (int i = 1; i <= 5; i++) {
			articles.add(new Article(lastArticleId++, Util.getDateStr(), "제목" + i, "내용" + i, i * 10));
		}
	}
}

class Article {
	int id;
	String regDate;
	String title;
	String text;
	int viewCnt;
	
	

//	생성자를 만들어줘서 Main 클래스 안 지역변수에 코드를 최적화 시킬 수 있다.
	Article(int id, String regDate, String title, String text, int viewCnt) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.text = text;
		this.viewCnt = viewCnt;
		
				
	}
	
	void incrementViews() {
		this.viewCnt++;
	}
}

class Post {
	LocalDateTime util;
	String title;
	String text;
	
	Post(LocalDateTime util, String title, String text) {
		this.util = util;
		this.title = title;
		this.text = text;
	}
	
}

