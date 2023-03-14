package org.iclass.controller.example;

import java.security.Timestamp;
import java.sql.Date;
import java.util.Iterator;
import java.util.Map;

import org.iclass.dto.NewMember;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;


@Controller		//bean 생얼을 표기하는 @Component 대신 MVC모델에서 사용
@Slf4j
public class HomeController {
	//요청을 처리하는 메소드는 핸들러 메소드라고 부릅니다.
	
	//method = RequestMethod.GET 은 기본값. POST 일때는 필수 표기
	@RequestMapping(value = {"/","home"}, method = RequestMethod.GET)
	public String home() {
		
		
		return "index";    		//view 화면 정보 : ViewResolver 가 앞,뒤로 텍스트를 추가해서 파일을 찾아갑니다.
	}

	@RequestMapping("hello1") //hello url 요청은 hello메소드가 처리한다.(메소드이름은 임의로)
	public String hello1(String search) {	//메소드의 인자가 파라미터 값을 받아서 저장.
		log.info("search 파라미터 - {}",search);
		return "redirect:/";	//context path 를  url로 리다이렉트
	}
	
	@RequestMapping("hello2")
	public String hello2(int year,String text) {
		//request.getParameter 는 String타입 => 정의된 타입으로 자동 캐스팅
		log.info("year 파라미터 - {}, text 파라미터 - {}",year,text);
		return "redirect:/";	//context path 를  url로 리다이렉트
	}
	
	@RequestMapping("hello3")
	public String hello3(@RequestParam Map<String, Object> param) {	
		//Map으로 파라미터 받을때는 Key는 파라미터 이름, value는 값
		//Map으로 받을 때는 @RequestParam 꼭 필요.
		log.info("-Map으로 받은 파라미터 - {}",param);
		log.info("-Map으로 받은 search 파라미터 - {}",param.get("search"));
		log.info("-Map으로 받은 text 파라미터 - {}",param.get("text"));
		log.info("-Map으로 받은 field 파라미터 - {}",param.get("field"));
		return "redirect:/";	//context path 를  url로 리다이렉트
	}
	
	@RequestMapping("hello4")
	public String hello4(@RequestParam Map<String, Object> param) {
		log.info("-Map으로 받은 파라미터 - {}",param);
		log.info("-Map으로 받은 id 파라미터 - {}",param.get("id"));
		log.info("-Map으로 받은 name 파라미터 - {}",param.get("name"));
		log.info("-Map으로 받은 email 파라미터 - {}",param.get("email"));
		log.info("-Map으로 받은 age 파라미터 - {}",param.get("age"));
		
		return "redirect:/";	//context path 를  url로 리다이렉트
	}
	
	@RequestMapping("hello5")
	public String hello5(NewMember vo) {	//vo 클래스의 필드와 직접 매핑될 수 있습니다.
		log.info("파라미터 4개가 NewMember 객체 생성하여 잘 전달되었는가? {}",vo);
		return "redirect:/";
	}
	
}
