package com.my.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.my.DTO.BoardDTO;
import com.my.DTO.ImgFileDTO;

public interface BoardDAO {
	// mybatis에 접근하기 위한 인터페이스는 매개변수에 String 하나는 사용 가능하지만
		// String,String으로 두 개를 동시 사용 불가능
		// 두개 이상의 변수를 전달하고자 할 때,
		// 1. @Param 어노테이션을 이용하는 방법
		// 2. 객체를 이용하는 방법
		// 3. HashMap을 이용하는 방법

	public ArrayList<BoardDTO> selectAll();

	public void insertBoard(BoardDTO bdto);

	public void insertFile(Map<String, Object> map);

	public ArrayList<ImgFileDTO> selectImg();

	public BoardDTO selectOne(int no);

	public ImgFileDTO selectImgOne(int no);

	public void deleteBoard(int no);

	public void modifyBoard(BoardDTO bdto);

	public void modifyImg(Map<String, Object> map);


}
