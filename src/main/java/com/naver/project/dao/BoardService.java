package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import com.naver.project.model.BoardBean;
import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;


public interface BoardService {
	/*�ڷ�� ����*/
	public void insertBoard(BoardBean bbsbean) throws Exception;

	/* �ڷ�� �� �Խù� ��*/
	public int getListCount() throws Exception;
	
	/* �ڷ�� ��ϰ� ����¡ */
	public List<BoardBean> getBoardList(int page) throws Exception ;

	/*��ȣ�� �������� �ڷ�� ���� �������� */
	public BoardBean getBoardCont(int num) throws Exception;

	/*���뺸�� �Ҷ��� ��ȸ�� ����*/
	public void BoardHit(int num) throws Exception;

	/*�ڷ�� ����*/
	public void editBoard(BoardBean bbsbean) throws Exception;

	/*�ڷ�� ����*/
	public void deleteBoard(int bbs_num) throws Exception;

	/*�˻� ��� �Խù� ��*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getListCount2(Map m) throws Exception;

	/*�˻� ��� ����¡ ���*/
	public List<BoardBean> getBoardList2(Map m) throws Exception ;

	/*�亯�� ���� ����*/
	public void refEdit(BoardBean bbsbean) throws Exception;

	/*�亯�� ����*/
	public void BoardReplyOk(BoardBean bbsbean) throws Exception;
	
	/*���� Ŭ���� ��ü ����Ʈ */
	public List<CarBean> getCarClassAll() throws Exception;

	/*���� Ŭ������ �ش��ϴ� �� ��ü ����Ʈ */
	public List<CarBean> getCarModelAll(String car_class) throws Exception;

	/* Ŭ����, ��, ������ȣ�� �ش��ϴ� ���� �˻� ��� */
	public List<CarBean> getCarSearchResult(Map m) throws Exception;
	
	/* �Խñۿ� ��ϵ� ���� ���� */
	public CarBean getCarCont(String car_no) throws Exception;
	
	/* ���� ���̵�� ���� ���� �������� */
	public DealerBean getDealerCont(String dealer_id)throws Exception;

	/* �Խñ� �󼼺��� - �ش� �Խñ۰� ���õ� ��, ��� ����Ʈ */
	public List<BoardBean> getReplyList(int board_re_ref)throws Exception;
	
	/* �Խñ� ��� (��������) */
	public List<BoardBean> getBoardList_dealer(Map<String, Object> m)throws Exception;
	
	/* �Խñ� ���� (��������) */
	public int getListCount_dealer(String id) throws Exception;
	
	/* �Խñ� ��� (�����ڱ���) */
	public List<BoardBean> getBoardList_admin(Map<String, Object> m);
}
