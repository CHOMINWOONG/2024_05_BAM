package com.koreaIT.BAM.container;

import java.util.ArrayList;
import java.util.List;

import com.koreaIT.dto.Article;
import com.koreaIT.dto.Member;

public class container {
	public static List<Member> members;
	public static List<Article> articles;
	
	static {
		members = new ArrayList<>();
		articles = new ArrayList<>();
	}
}
