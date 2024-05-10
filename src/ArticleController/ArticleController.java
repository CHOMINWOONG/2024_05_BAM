package ArticleController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.dto.Article;
import com.koreaIT.util.Util;

public class ArticleController {
	
	Scanner sc;
	private List<Article> articles = new ArrayList<>();
	private int lastArticleId;
	String cmd = sc.nextLine().trim();
	
	public ArticleController(Scanner sc) {
		this.sc = sc;
		this.articles = new ArrayList<>();
		this.lastArticleId = 1;
	}
	
	void doArticle() {
		 if (cmd.equals("article write")) {
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
				continue;
			} 				
//			substring 인덱스 인자값을 받아서 그 후부터 나오게 하는 함수
			String searchKeyword = cmd.substring("article list".length()).trim();
			
			List<Article> printArticles = articles;
			
			
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
			
			System.out.println("번호    |	제목	|	      날짜	        |   조회수");
													
				for (int i = printArticles.size() - 1; i >= 0; i--) {
					Article article = printArticles.get(i);
					System.out.printf("%d	|	%s	|	%s	|	%d\n", article.getId(), article.getTitle(), article.getRegDate(), article.getViewCnt());
				}												
		}
		 else if (cmd.startsWith("article detail ")) {
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
		
	}
	private Article getArticleById(int id) {

		for (Article article : articles) {
			if (article.getId() == id) {
				return article;
			}
		}

		return null;
	}
	public void makeTestData() {
		System.out.println("테스트용 게시글 데이터를 5개 생성했습니다");

		for (int i = 1; i <= 5; i++) {
			articles.add(new Article(lastArticleId++, Util.getDateStr(), "제목" + i, "내용" + i, i * 10));
			}
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
}
