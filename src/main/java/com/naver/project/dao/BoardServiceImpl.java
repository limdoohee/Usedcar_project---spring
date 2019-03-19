package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.project.model.BoardBean;
import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAOImpl boardDAO;

	@Override
	public void insertBoard(BoardBean bbsbean) throws Exception {
		boardDAO.insertBoard(bbsbean);
	}

	@Override
	public int getListCount() throws Exception {
		return boardDAO.getListCount();
	}

	@Override
	public List<BoardBean> getBoardList(int page) throws Exception {
		return boardDAO.getBoardList(page);
	}

	@Override
	public BoardBean getBoardCont(int num) throws Exception {
		return boardDAO.getBoardCont(num);
	}

	@Override
	public void BoardHit(int num) throws Exception {
		boardDAO.BoardHit(num);
	}

	@Override
	public void editBoard(BoardBean bbsbean) throws Exception {
		boardDAO.editBoard(bbsbean);
	}

	@Override
	public void deleteBoard(int bbs_num) throws Exception {
		boardDAO.deleteBoard(bbs_num);
	}


	@Override
	public void refEdit(BoardBean board) throws Exception {
		boardDAO.refEdit(board);
	}

	@Override
	public void BoardReplyOk(BoardBean bbsbean) throws Exception {
		boardDAO.BoardReplyOk(bbsbean);
	}

	@Override
	public int getListCount2(Map m) throws Exception {
		return boardDAO.getListCount2(m);
	}

	@Override
	public List<BoardBean> getBoardList2(Map m) throws Exception {
		return boardDAO.getBoardList2(m);
	}

	@Override
	public List<CarBean> getCarClassAll() throws Exception {
		return boardDAO.getCarClassAll();
	}

	@Override
	public List<CarBean> getCarModelAll(String car_class) throws Exception {
		return boardDAO.getCarModelAll(car_class);
	}

	@Override
	public List<CarBean> getCarSearchResult(Map m) throws Exception {
		return boardDAO.getCarSearchResult(m);
	}

	@Override
	public CarBean getCarCont(String car_no) throws Exception {
		return boardDAO.getCarCont(car_no);
	}

	@Override
	public DealerBean getDealerCont(String dealer_id) throws Exception {
		return boardDAO.getDealerCont(dealer_id);
	}

	@Override
	public List<BoardBean> getReplyList(int board_re_ref) throws Exception {
		return boardDAO.getReplyList(board_re_ref);
	}

	@Override
	public List<BoardBean> getBoardList_dealer(Map<String, Object> m) throws Exception {
		return boardDAO.getBoardList_dealer(m);
	}

	@Override
	public int getListCount_dealer(String id) throws Exception {
		return boardDAO.getListCount_dealer(id);
	}

	@Override
	public List<BoardBean> getBoardList_admin(Map<String, Object> m) {
		return boardDAO.getBoardList_admin(m);
	}
	
}
