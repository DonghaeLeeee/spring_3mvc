package org.iclass.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.dto.NewMember;

@Mapper
public interface MemberMapper {
	int insert(NewMember member);
	int update(NewMember member);
	int delege(String id );
	NewMember selectOne(String id);
	List<NewMember> selectAll();
	NewMember login(Map<String,String> map);
}
