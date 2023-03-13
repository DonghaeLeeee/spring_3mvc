package org.iclass.controller;

import org.iclass.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminController {
	private final MemberService service;
	
	@RequestMapping("members")
	public String members(Model model) {
		
		model.addAttribute("list",service.list());
		return "admin/members";	//jsp 파일이 저장된 하위폴더 admin
	}
	
	
	@RequestMapping("/member")
	public String member(Model model, String id) {
		model.addAttribute("member",service.member(id));
		return"admin/member";
	}
}
