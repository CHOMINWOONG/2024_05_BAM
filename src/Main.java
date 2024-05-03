import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("== 프로그램 시작 ==");
//		데이터타입을 받을 함수 Scanner
		Scanner sc = new Scanner(System.in);
		int i = 1;
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
				System.out.println("게시글이 없습니다");
				
			} else if (cmd.equals("article write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String text = sc.nextLine();
				
				System.out.println(i + "번 게시물이 생성되었습니다.");
				i++;
				continue;
				
			} else {
				System.out.println("존재하지 않는 명령어 입니다");
			}
			
			
		}
		
		sc.close();
		System.out.println("== 프로그램 끝 ==");
	}
}
