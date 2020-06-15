package com.my.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.my.DTO.BoardDTO;
import com.my.DTO.ImgFileDTO;

//컨트롤러에서 모델로 접근하기 위한 인터페이스(상속받는 클래스는 하나만 있을 수 있음)
public interface ControllerToModelBoard {

	public ArrayList<BoardDTO> selectAll();

	public void insertBoard(BoardDTO bdto, MultipartHttpServletRequest mhsr) throws Exception;

	public ArrayList<ImgFileDTO> selectImg();

	public BoardDTO selectOne(int no);

	public ImgFileDTO selectImgOne(int no);

	public void deleteBoard(int no);

	public void modifyBoard(BoardDTO bdto, MultipartHttpServletRequest mhsr, int mod_f_no) throws Exception;

}
