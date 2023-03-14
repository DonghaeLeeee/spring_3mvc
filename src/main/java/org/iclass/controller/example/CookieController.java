package org.iclass.controller.example;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CookieController {

	@GetMapping("cookie")
	public String cookie(HttpServletResponse response) {
		
		//서블릿/JSP에서 쿠키는 브라우저에 저장되는 문자열 데이터.쿠키의 기본 수명은 세션 동일
		// 쿠키 유지시간은 변경 가능합니다. 
		//쿠키는 브라우저에 저장하므로 response 객체에 쿠키 저장메소드가 있습니다.
		
		//1. 쿠키 생성
		Cookie cookie = new Cookie("search","spring");  //key-value 한쌍
		cookie.setPath("/");		//쿠키 저장 경로
		
		//2. 쿠키 값을 응답객체와 함께 브라우저에 전달
		response.addCookie(cookie);
		
		return "cookie";
	}
	
	
	@GetMapping("cookieVal")  //쿠키는 기존 방식은 배열로 가져오기. @CookieValue 는 이름 지정하여 값 가져오기
	public String cookieVal(@CookieValue(name="search",required = false) String search) {
		log.info("쿠키 이름 search , 값 : {}",search);
		
		return "redirect:/";
	}
	
}




