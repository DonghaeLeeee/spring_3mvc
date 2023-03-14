package org.iclass.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.iclass.dto.NewMember;
import org.iclass.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {
	private final MemberService service;

	//로그인 화면
	@GetMapping("/login")    //GET 요청일때 @GetMapping
	public void login() {
		//url과 리턴되는 view 파일이름이 같으면 생략가능합니다.
	}
	
	//id,password 검사해서 alert 또는 화면에 메시지 출력
	@PostMapping("/login")  //POST 요청일때 @PostMapping
//	public String loginProc(String id, String password,RedirectAttributes reattr){
	public String loginProc(@RequestParam Map<String,String> param,
			RedirectAttributes reattr,
			HttpSession session){
		String message = "로그인 계정 정보가 다릅니다.";
		String url="/";		//계정정보가 일치할때 index로 이동
//		if(service.login(id, password)==null) {	//계정 정보가 틀릴때
		NewMember member = service.login(param);
		if(member==null) {	//계정 정보가 틀릴때
			reattr.addFlashAttribute("alert",message);
			url="login";
		}	else {
			session.setAttribute("member", member);
		}
		return "redirect:"+url;		
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}