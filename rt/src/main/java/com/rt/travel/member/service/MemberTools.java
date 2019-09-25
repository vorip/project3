package com.rt.travel.member.service;

import org.springframework.stereotype.Repository;

@Repository
public class MemberTools {

	public String login() {
		return "<form action=\"login\">" + 
				"<div class=\"loginDiv\">"+
				"아이디 : <input type=\"text\" name=\"id\" class=\"loginInput\"><br>" + 
				"비밀번호 : <input type=\"text\" name=\"pw\" class=\"loginInput\"><br>" + 
				"<input type=\"submit\" value=\"로그인\" id=\"loginbtn\">" + 
				"<input type=\"button\" value=\"회원가입\" id=\"signbtn\" onclick=\"location='sign'\">"+
				"</div>"+
				"</form>" + 
				"<div class=\"searchIdPw\">"+
				"<a href=\"searchId\" class=\"aTag\" style=\"text-decoration: none;\">아이디 찾기</a>" + 
				"<a href=\"searchPw\" class=\"aTag\" style=\"text-decoration: none;\" >비밀번호 찾기</a>"+
				"</div>";
	}
}
