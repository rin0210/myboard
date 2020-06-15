package com.my.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.DTO.MemberDTO;
import com.my.mapper.MemberDAO;

@Service("memberDB") // 어떤 모델의 객체를 서비스할 것인가를 정의해주어야함(testDB라는 객체로 서비스해라), servlet-context에 빈 설정해줌
public class MemberService implements ControllerToModelMember {
	// 컨트롤러가 모델로 지정한 클래스객체로 접근하기 위해서는 자바처럼 객체 생성하고 참조변수로 접근해도됨
	// 어노테이션 서비스를 쓰는 이유 : 하나의 스레드를 공용으로 쓰기 위함
	// 스프링은 객체 하나당 하나의 스레드를 만드는게 아니라 하나의 스레드를 공용으로 사용

	private MemberDAO mapper;

	@Autowired // 해당되는 객체를 자동 주입
	private SqlSession sqlSession;

	@Override
	public MemberDTO selectOne(String id) {
		mapper = sqlSession.getMapper(MemberDAO.class);
		return mapper.selectOne(id);
	}

	@Override
	public void insertMember(String id, String name, String pwd) {
		mapper = sqlSession.getMapper(MemberDAO.class);
		mapper.insertMember(id, name, pwd);
	}

}
