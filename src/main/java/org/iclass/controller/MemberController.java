package org.iclass.controller;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.iclass.dto.NewMember;
import org.iclass.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)   //final 변수만 생성자 인자로 초기화
//객체 생성의 안정성을 위해 접근한정자는 private
public class MemberController {
	//MVC 모델 의존성 : Controller -> Service -> Dao
	
	private final MemberService service;
	//final 변수는 초기값이 꼭 필요합니다.
	//@RequiredArgsConstructor 는 service 필드 초기화하는 생성자가 생기면서
	// @Autowired 로 객체 주입(생성자 주입- @Autowired생략가능)
	
	@RequestMapping("/join")
	public String join() {
		return "member/join";    //member폴더에 join.jsp 
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String save(NewMember vo) {
		//취미 파라미터는 여러개 값의 배열로 전달됩니다.
		//테이블 컬럼은 문자열 1개 이므로 변환이 필요합니다.
		vo.setHobbies(Arrays.toString(vo.getHobby()));
		service.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "member/update";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateSave(NewMember vo,HttpSession session) {
		vo.setHobbies(Arrays.toString(vo.getHobby()));
		int result = service.update(vo);
		if(result==1)
			session.setAttribute("member", vo);
		return "redirect:/";
	}
	
	
}