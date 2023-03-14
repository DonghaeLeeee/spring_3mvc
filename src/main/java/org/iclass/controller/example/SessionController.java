package org.iclass.controller.example;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@SessionAttributes({ "username", "location" })
public class SessionController {

	// 핸들러 메소드 : HttpServletRequest,HttpServletResponse, HttpSession 를 선언해서
	// 서블릿 처럼 사용 가능합니다.
	@GetMapping("session")
	public void session(HttpSession session, Model model) {
		model.addAttribute("sessionId", session.getId());
		model.addAttribute("userid", "twice-트와이스"); // request.setAttribute
//세션에 데이터(애트리뷰트) 저장하기
		session.setAttribute("userid", "twice-트와이스"); // 방법1)
		model.addAttribute("username", "김모모"); // 방법2)
		model.addAttribute("location", "seoul");
// Model 객체에 저장한 애트리뷰트를 
//@SessionAttributes에 (애트리뷰트 이름)지정하면 세션범위에서 사용합니다.

		// 리턴타입이 void 일때는 url과 view(jsp) 파일명이 같은 때 생략.
	}

	@GetMapping("sessionAttr")
	public String sessionAttr(@SessionAttribute(value = "userid", required = false) String userid,
			@SessionAttribute("username") String username, @SessionAttribute("location") String location) {
//방법1,2 모두 값이 없으면 400 오류 -> required = false 속성은 세션에 값이 없어도 오류 발생 안함.		
//	@SessionAttribute 는 세션에 저장된 데이터 가져오기	방법2)
//  메소드 매개변수 HttpSession session 선언, session.getAttribute 가능 : 방법1)
		log.info("userid-{}", userid);
		log.info("username-{}", username);
		log.info("location-{}", location);

		return "redirect:session";
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 기존 세션 id삭제
		// 방법1) 세션 애트리뷰트 중에 session.setAttribute 로 저장한 것만 삭제
		return "redirect:./"; // 새로운 세션 id 발급
	}

	@GetMapping("removeAttr")
	public String removeAttr(HttpSession session, SessionStatus status) {
		// 방법2) 세션 범위의 Model 데이터 삭제(removeAttribute), 세션 id는 유지
		log.info("setComplete 하기 전 session id : {}", session.getId());
		status.setComplete();
		log.info("setComplete 실행 후 session id : {}", session.getId());
		return "redirect:./";
	}
}