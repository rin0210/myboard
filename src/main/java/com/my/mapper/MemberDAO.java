package com.my.mapper;

import org.apache.ibatis.annotations.Param;

import com.my.DTO.MemberDTO;

// 모델에서 sqlSession(mybatis)으로 접근하기 위한 인터페이스
public interface MemberDAO {
	// mybatis에 접근하기 위한 인터페이스는 매개변수에 String 하나는 사용 가능하지만
	// String,String으로 두 개를 동시 사용 불가능
	// 두개 이상의 변수를 전달하고자 할 때,
	// 1. @Param 어노테이션을 이용하는 방법
	// 2. 객체를 이용하는 방법
	// 3. HashMap을 이용하는 방법

	public MemberDTO selectOne(String id);

	public void insertMember(@Param("id") String id, @Param("name") String name, @Param("pwd") String pwd);

}
