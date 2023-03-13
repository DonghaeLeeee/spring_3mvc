package org.iclass.controller;

import org.iclass.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	private final MemberService service;

	//로그인 화면
	@GetMapping("/login")
	public void login() {
		//url과 리턴되는 view 파일이름이 같으면 생략가능합니다.
	}
	
	//id,password 검사해서 alert 또는 화면에 메시지 출력
	@PostMapping("/login") 
	public String loginProc(String id, String password,RedirectAttributes reattr){
		String message = "로그인 계정 정보가 다릅니다.";
		String url="/";
		if(service.login(id, password)==null) {
			reattr.addFlashAttribute("alert",message);
			url="login";
		}	
		return "redirect:"+url;
	}


	//세션에 애트리뷰트 저장은 나중에.....
}