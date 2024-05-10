package com.koreaIT.BAM;
<<<<<<< HEAD
=======

>>>>>>> a46f3ab77df4ad85309777e9b809ecf89251f1c9
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.dto.Article;
<<<<<<< HEAD
import com.koreaIT.dto.Member;
=======
>>>>>>> a46f3ab77df4ad85309777e9b809ecf89251f1c9
import com.koreaIT.util.Util;

public class App {
	
	private List<Article> articles = new ArrayList<>();
<<<<<<< HEAD
	private List<Member> members = new ArrayList<>();
	private int lastArticleId = 1;
	private int memberArticleId = 1;
=======
	private int lastArticleId = 1;
>>>>>>> a46f3ab77df4ad85309777e9b809ecf89251f1c9
	
	
	public App() {		
		articles = new ArrayList<>();
<<<<<<< HEAD
		
=======
>>>>>>> a46f3ab77df4ad85309777e9b809ecf89251f1c9
		lastArticleId = 1;
	}


	public void run() {



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
			
<<<<<<< HEAD
			if (cmd.equals("member join")) {
				
				System.out.printf("아이디: ");
				String loginId = sc.nextLine().trim();
				System.out.printf("비밀번호 ");
				String loginPw = sc.nextLine().trim();
				System.out.printf("비밀번호 확인 ");
				String loginPwChk = sc.nextLine().trim();
				System.out.printf("이름 ");
				String name = sc.nextLine().trim();
				
				Member member = new Member(memberArticleId, Util.getDateStr(), loginId, loginPw, name);
				members.add(member);
				
				System.out.println(memberArticleId + "번 회원이 가입되었습니다.");
				memberArticleId++;
				continue;
				
				
			} else if (cmd.equals("article write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String text = sc.nextLine().trim();		
				
				
				int viewCnt = 0;
				
				
				Article article = new Article(lastArticleId, Util.getDateStr(), title, text, viewCnt);
				articles.add(article);
				System.out.println(lastArticleId + "번 게시물이 생성되었습니다.");
				lastArticleId++;
				continue;
				
			} if (cmd.startsWith("article list")) {
				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다.");		
=======
			if (cmd.startsWith("article list")) {
				if (articles.size() == 0) {
					System.out.println("존재하는 게시글이 없습니다.");
					
>>>>>>> a46f3ab77df4ad85309777e9b809ecf89251f1c9
					continue;
				} 				
//				substring 인덱스 인자값을 받아서 그 후부터 나오게 하는 함수
				String searchKeyword = cmd.substring("article list".length()).trim();
				
				List<Article> printArticles = articles;
				
<<<<<<< HEAD
				
=======
>>>>>>> a46f3ab77df4ad85309777e9b809ecf89251f1c9
				if (searchKeyword.length() > 0) {
					System.out.println("검색어 : " + searchKeyword);
					
					printArticles = new ArrayList<>();
					
					for (Article article : articles) {
						if (article.getTitle().contains(searchKeyword)) {
							printArticles.add(article);
						}					
				}
					
				if (printArticles.size() == 0) {
						System.out.println("검색결과가 존재하지않습니다.");
						continue;
					}								
				}
				
<<<<<<< HEAD
				System.out.println("번호    |	제목	|	      날짜	        |   조회수");
														
					for (int i = printArticles.size() - 1; i >= 0; i--) {
						Article article = printArticles.get(i);
						System.out.printf("%d	|	%s	|	%s	|	%d\n", article.getId(), article.getTitle(), article.getRegDate(), article.getViewCnt());
					}												
			}
			 else if (cmd.startsWith("article detail ")) {
=======
				if (articles.size() != 0) {
					System.out.println("번호    |	제목	|	      날짜	        |   조회수");					
					for (int i = printArticles.size() - 1; i >= 0; i--) {
						Article article = printArticles.get(i);
						System.out.printf("%d	|	%s	|	%s	|	%d\n", article.getId(), article.getTitle(), article.getRegDate(), article.getViewCnt());
					}				
				}				
			}
			else if (cmd.equals("article write")) {
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
																
				int id = getNum(cmd);
				Article foundArticle = 	getArticleById(id);
				
					if (foundArticle == null) {
						System.out.println(id + "번 게시물이 존재하지 않습니다.");
						continue;
					}
					
					foundArticle.incrementViews();
					
					System.out.println("번호 : " + foundArticle.getId());
					System.out.println("날짜 : " + foundArticle.getRegDate());
					System.out.println("제목 : " + foundArticle.getTitle());
					System.out.println("내용 : " + foundArticle.getText());
					System.out.println("조회수 : " + foundArticle.getViewCnt());
					
					
			    
					
			} else if (cmd.startsWith("article detail ")) {
>>>>>>> a46f3ab77df4ad85309777e9b809ecf89251f1c9
				int id = getNum(cmd);

				if (id == 0) {
					System.out.println("명령어가 올바르지 않습니다");
					continue;
				}

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다");
					continue;
				}

				foundArticle.incrementViews();

				System.out.println("번호 : " + foundArticle.getId());
				System.out.println("날짜 : " + foundArticle.getRegDate());
				System.out.println("제목 : " + foundArticle.getTitle());
				System.out.println("내용 : " + foundArticle.getText());
				System.out.println("조회수 : " + foundArticle.getViewCnt());

			} else if (cmd.startsWith("article delete ")) {
				int id = getNum(cmd);

				if (id == 0) {
					System.out.println("명령어가 올바르지 않습니다");
					continue;
				}

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다");
					continue;
				}

				articles.remove(foundArticle);

				System.out.println(id + "번 게시물이 삭제되었습니다");

			} else if (cmd.startsWith("article modify ")) {
				
				
				int id = getNum(cmd);										
				Article foundArticle = getArticleById(id);	
				
				
				
				if (foundArticle == null) {
					System.out.println(id + "번 게시물이 존재하지 않습니다.");
					continue;
				}
				
				System.out.printf("수정할 제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("수정할 내용 : ");
				String text = sc.nextLine().trim();
				
				foundArticle.setTitle(title);
				foundArticle.setText(text);
				
				System.out.println(id + "번 게시물이 수정되었습니다.");
			}
				
			
			
			
			else {
					System.out.println("존재하지 않는 명령어 입니다");
				}
				
				
			}
			
			sc.close();
			System.out.println("== 프로그램 끝 ==");
	}
	private Article getArticleById(int id) {

		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}

		return null;
	}

	private int getNum(String cmd) {
		String[] cmdBits = cmd.split(" ");

		try {
			int id = Integer.parseInt(cmdBits[2]);
			return id;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	private void makeTestData() {
		System.out.println("테스트용 게시글 데이터를 5개 생성했습니다");

		for (int i = 1; i <= 5; i++) {
			articles.add(new Article(lastArticleId++, Util.getDateStr(), "제목" + i, "내용" + i, i * 10));
			}
		}
}

