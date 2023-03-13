package org.iclass.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iclass.dao.MemberMapper;
import org.iclass.dto.NewMember;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
//Service 클래스에 비지니스 로직 구현 - 트랜잭션 처리 등등..
@Slf4j
public class MemberService {
	
	private final MemberMapper dao;
	
	
	public NewMember login(String userid,String password) {
		
		Map<String, String> map= new HashMap<>();
		map.put("id",userid);
		map.put("password",password);
		log.info("login map - {}",map);
		return dao.login(map);
	}
	
	public NewMember member(String id) {
		return dao.selectOne(id);
	}
	
	public List<NewMember> list(){
		return dao.selectAll();
	}

	public void insert(NewMember vo) {
		//db 저장
		dao.insert(vo);
	}
}