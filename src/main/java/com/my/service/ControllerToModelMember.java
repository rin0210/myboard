package com.my.service;

import com.my.DTO.MemberDTO;

//컨트롤러에서 모델로 접근하기 위한 인터페이스(상속받는 클래스는 하나만 있을 수 있음)
public interface ControllerToModelMember {

	public MemberDTO selectOne(String id);

	public void insertMember(String id, String name, String pwd);

}
