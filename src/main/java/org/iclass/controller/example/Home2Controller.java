package org.iclass.controller.example;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class Home2Controller {
	//Model 애트리뷰트 연습하는 컨트롤러
	
	//1.jsp로 애트리뷰트로 전달
	@RequestMapping("/spring")
	public String spring1(Model model) {
		model.addAttribute("message", "스프링 web MVC 모델 애트리뷰트 연습중....");
		model.addAttribute("list", List.of("java", "파이썬", "spring","자바스크립트"));
		return "result";	//result.jsp 로 애트리뷰트값을 전달
	}
	
	//2.POST 요청 처리 후 redirect 할 때 애트리뷰트 저장하면 
	// 					리다이렉트 url의 파라미터가 됩니다.
	@RequestMapping(value = "/spring",method=RequestMethod.POST)
	public String save(String test,Model model) {
		log.info("테스트 값 파라미터 - {}",test);
		model.addAttribute("alert", "success");
		model.addAttribute("name", "트와이스");
		return "redirect:/";
	}
	//3. spring mvc 에서는 리다이렉트를 위한 flash 애트리뷰트가 있습니다.
	//   -> url 표시 되지 않고 한번만 사용하는 애트리뷰트입니다.
	@RequestMapping(value="/spring2",method=RequestMethod.POST)
	public String spring2(String test,RedirectAttributes reattr) {
		log.info("테스트 값 파라미터 - {}",test);
		reattr.addFlashAttribute("alert", "성공했습니다.");
		return "redirect:/";
	}
/*	
	@RequestMapping("modelAttr")
	public String modelAttr( String column,  String text,   //파라미터 2개
			Model model) {    //view 전달하기 위해 선언
		model.addAttribute("column", column);  //view 전달할 값 저장
		model.addAttribute("text", text);
		
		return "index";
	}
*/
	//위의 view로부터 받은 파라미터 값을 Model 객체에 저장해서 view 로 전달할때
	//Model 선언부분과 저장하는 코드 대신에 @ModelAttribute 사용
	@RequestMapping("modelAttr")
	public String modelAttr( @ModelAttribute("column") String column, 
		@ModelAttribute("text") String text) {
		return "index";
	}
	
	
}