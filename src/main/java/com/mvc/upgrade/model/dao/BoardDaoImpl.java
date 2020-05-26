package com.mvc.upgrade.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.upgrade.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardDto> selectList() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			list = sqlSession.selectList(NAMESPACE + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error] : selectList");
		}	
		return list;
	}

	@Override
	public BoardDto selectOne(int myno) {
		BoardDto dto = null;
		
		try {
			dto = sqlSession.selectOne(NAMESPACE + "selectOne", myno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error] : selectOne");
		}
		
		return dto;
	}

	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.insert(NAMESPACE + "insert", dto);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error] : insert");
		}
		
		return res;
	}

	@Override
	public int update(BoardDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error] : update");
		}
		
		return res;
	}

	@Override
	public int delete(int myno) {
		int res = 0;
		
		try {
			res = sqlSession.update(NAMESPACE + "delete", myno);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error] : delete");
		}
		
		return res;
	}

}
