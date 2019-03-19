package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import com.naver.project.model.BoardBean;
import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;


public interface BoardService {
	/*자료실 저장*/
	public void insertBoard(BoardBean bbsbean) throws Exception;

	/* 자료실 총 게시물 수*/
	public int getListCount() throws Exception;
	
	/* 자료실 목록과 페이징 */
	public List<BoardBean> getBoardList(int page) throws Exception ;

	/*번호를 기준으로 자료실 내용 가져오기 */
	public BoardBean getBoardCont(int num) throws Exception;

	/*내용보기 할때만 조회수 증가*/
	public void BoardHit(int num) throws Exception;

	/*자료실 수정*/
	public void editBoard(BoardBean bbsbean) throws Exception;

	/*자료실 삭제*/
	public void deleteBoard(int bbs_num) throws Exception;

	/*검색 결과 게시물 수*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getListCount2(Map m) throws Exception;

	/*검색 결과 페이징 목록*/
	public List<BoardBean> getBoardList2(Map m) throws Exception ;

	/*답변글 레벨 증가*/
	public void refEdit(BoardBean bbsbean) throws Exception;

	/*답변글 저장*/
	public void BoardReplyOk(BoardBean bbsbean) throws Exception;
	
	/*차량 클래스 전체 리스트 */
	public List<CarBean> getCarClassAll() throws Exception;

	/*차량 클래스에 해당하는 모델 전체 리스트 */
	public List<CarBean> getCarModelAll(String car_class) throws Exception;

	/* 클래스, 모델, 차량번호에 해당하는 차량 검색 결과 */
	public List<CarBean> getCarSearchResult(Map m) throws Exception;
	
	/* 게시글에 등록된 차량 정보 */
	public CarBean getCarCont(String car_no) throws Exception;
	
	/* 딜러 아이디로 딜러 정보 가져오기 */
	public DealerBean getDealerCont(String dealer_id)throws Exception;

	/* 게시글 상세보기 - 해당 게시글과 관련된 글, 답글 리스트 */
	public List<BoardBean> getReplyList(int board_re_ref)throws Exception;
	
	/* 게시글 목록 (딜러기준) */
	public List<BoardBean> getBoardList_dealer(Map<String, Object> m)throws Exception;
	
	/* 게시글 개수 (딜러기준) */
	public int getListCount_dealer(String id) throws Exception;
	
	/* 게시글 목록 (관리자기준) */
	public List<BoardBean> getBoardList_admin(Map<String, Object> m);
}
