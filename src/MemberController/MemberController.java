package MemberController;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.koreaIT.dto.Member;
import com.koreaIT.util.Util;

public class MemberController {
	
	private Scanner sc;
	private List<Member> members = new ArrayList<>();
	private int memberArticleId;
	
	public MemberController(Scanner sc) {
		
		this.sc = sc;
		this.members = new ArrayList<>();
		this.memberArticleId = 1;
	}
	
	public void doJoin() {
		String loginId = null;
		String loginPw = null;
		String loginPwChk = null;
		String name = null;
		boolean a = false;
		
		while(true) {
			
			System.out.printf("아이디: ");
			loginId = sc.nextLine().trim();
			
			if (loginId.length() == 0) {
				System.out.println("아이디는 필수 입력정보입니다.");
				continue;
			}
			if (loginIdDupChk(loginId) == false) {
				System.out.println("중복된 아이디입니다.");
				continue;
			}
			
			for (Member member : members) {
				if (member.getLoginId().equals(loginId)) {
					System.out.println("[" + loginId + "]는(은) 이미 사용 중인 아이디입니다.");
					a = true;
					break;							
				}
			}
			if (a == true) {
			continue;
			}
			break;
		}
						
		while (true) {
			System.out.printf("비밀번호 : ");
			loginPw = sc.nextLine().trim();
			
			if (loginPw.length() == 0) {
				System.out.println("비밀번호는 필수 입력정보입니다");
				continue;
			}
			
			System.out.printf("비밀번호 확인 : ");
			loginPwChk = sc.nextLine().trim();
			
			if (loginPw.equals(loginPwChk) == false) {
				System.out.println("비밀번호를 다시 입력해주세요");
				continue;
			}
			break;
		}
		
		
		while(true) {
		
		System.out.printf("이름 ");
		name = sc.nextLine().trim();
		if (name.length() == 0) {
			System.out.println("이름은 필수 입력정보입니다.");
			continue;
		}
		break;
		
		}
		
		Member member = new Member(memberArticleId, Util.getDateStr(), loginId, loginPw, name);
		members.add(member);
		
		System.out.println(memberArticleId + "번 회원이 가입되었습니다.");
		memberArticleId++;
		
	}
	
	private boolean loginIdDupChk(String loginId) {
		for (Member member : members) {
			if (member.getLoginId().equals(loginId)) {
				return false;
			}
		}
		return true;
	}
	
	public void makeTestMemberData() {
		System.out.println("테스트용 회원 데이터를 3개 생성했습니다");

		for (int i = 1; i <= 3; i++) {
			members.add(new Member(memberArticleId++, Util.getDateStr(), "user" + i, "user" + i, "유저" + i));
		}
	}
}
