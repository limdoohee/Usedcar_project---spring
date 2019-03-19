package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.project.model.BoardBean;
import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;

@Repository
public class BoardDAOImpl {
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	public int getListCount() {
		return sqlsession.selectOne("list_Count");
	}

	public List<BoardBean> getBoardList(int page) {
		return sqlsession.selectList("list_page",page);
	}

	public void insertBoard(BoardBean bbsbean) {
		sqlsession.insert("insert_board",bbsbean);
	}

	public int getListCount2(Map m) {
		return sqlsession.selectOne("search_count", m);
	}

	public List<BoardBean> getBoardList2(Map m) {
		return sqlsession.selectList("search_list", m);
	}
	
	public BoardBean getBoardCont(int num) {
		return sqlsession.selectOne("select_board",num);
	}

	public void refEdit(BoardBean board) {
		sqlsession.update("board_level",board);
	}

	public void BoardReplyOk(BoardBean bbsbean) {
		sqlsession.insert("insert_reply",bbsbean);
	}

	public void BoardHit(int num) {
		sqlsession.update("board_hit",num);
	}

	public void editBoard(BoardBean bbsbean) {
		sqlsession.update("boad_modity", bbsbean);
	}

	public List<CarBean> getCarClassAll() {
		return sqlsession.selectList("Board.car_class");
	}

	public List<CarBean> getCarModelAll(String car_class) {
		return sqlsession.selectList("Board.car_model", car_class);
	}

	public List<CarBean> getCarSearchResult(Map m) {
		return sqlsession.selectList("Board.car_list", m);
	}

	public CarBean getCarCont(String car_no) {
		return sqlsession.selectOne("Car.car_detail", car_no);
	}

	public DealerBean getDealerCont(String dealer_id) {
		return sqlsession.selectOne("Board.dealer_detail",dealer_id);
	}

	public List<BoardBean> getReplyList(int board_re_ref) {
		return sqlsession.selectList("board_re_list",board_re_ref);
	}

	public void deleteBoard(int bbs_num) {
		sqlsession.delete("board_delete",bbs_num);
	}

	public List<BoardBean> getBoardList_dealer(Map<String, Object> m) {
		return sqlsession.selectList("board_list_dealer", m);
	}

	public int getListCount_dealer(String id) {
		return sqlsession.selectOne("list_count_dealer", id);
	}

	public List<BoardBean> getBoardList_admin(Map<String, Object> m) {
		return sqlsession.selectList("board_list_admin",m);
	}

}
