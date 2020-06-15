package com.my.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.my.DTO.BoardDTO;
import com.my.DTO.ImgFileDTO;
import com.my.mapper.BoardDAO;
import com.my.util.FileUtils;

@Service("boardDB") // 어떤 모델의 객체를 서비스할 것인가를 정의해주어야함(boardDB라는 객체로 서비스해라), servlet-context에 빈 설정해줌
public class BoardService implements ControllerToModelBoard {
	// 컨트롤러가 모델로 지정한 클래스객체로 접근하기 위해서는 자바처럼 객체 생성하고 참조변수로 접근해도됨
	// 어노테이션 서비스를 쓰는 이유 : 하나의 스레드를 공용으로 쓰기 위함
	// 스프링은 객체 하나당 하나의 스레드를 만드는게 아니라 하나의 스레드를 공용으로 사용

	private BoardDAO mapper;
	
	@Autowired // 해당되는 객체를 자동 주입
	private SqlSession sqlSession;

	@Resource(name = "fileUtils")
	private FileUtils fileUtils;

	@Override
	public ArrayList<BoardDTO> selectAll() {
		mapper = sqlSession.getMapper(BoardDAO.class);
		ArrayList<BoardDTO> blist = mapper.selectAll();
		return blist;
	}

	@Override
	public void insertBoard(BoardDTO bdto, MultipartHttpServletRequest mhsr) throws Exception {
		mapper = sqlSession.getMapper(BoardDAO.class);
		mapper.insertBoard(bdto);

		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(bdto, mhsr, 0);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			mapper.insertFile(list.get(i));
		}
	}

	@Override
	public ArrayList<ImgFileDTO> selectImg() {
		mapper = sqlSession.getMapper(BoardDAO.class);
		ArrayList<ImgFileDTO> imgList = mapper.selectImg();
		return imgList;
	}

	@Override
	public BoardDTO selectOne(int no) {
		mapper = sqlSession.getMapper(BoardDAO.class);
		BoardDTO bdto = mapper.selectOne(no);
		return bdto;
	}

	@Override
	public ImgFileDTO selectImgOne(int no) {
		mapper = sqlSession.getMapper(BoardDAO.class);
		ImgFileDTO img = mapper.selectImgOne(no);
		return img;
	}

	@Override
	public void deleteBoard(int no) {
		mapper = sqlSession.getMapper(BoardDAO.class);
		mapper.deleteBoard(no);
	}

	@Override
	public void modifyBoard(BoardDTO bdto, MultipartHttpServletRequest mhsr, int mod_f_no) throws Exception {
		mapper = sqlSession.getMapper(BoardDAO.class);
		mapper.modifyBoard(bdto);
		
		List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(bdto, mhsr, mod_f_no);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			mapper.modifyImg(list.get(i));
		}
	}

	

	

}
