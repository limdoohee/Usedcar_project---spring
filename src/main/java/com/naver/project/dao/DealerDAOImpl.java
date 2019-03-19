package com.naver.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;
import com.naver.project.model.StoreBean;

@Repository
public class DealerDAOImpl {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/* ����, ������ �α��� üũ */
	public DealerBean dealercheck(String id) {
		
		DealerBean dealer = (DealerBean) sqlSession.selectOne("Dealer.dealer_admin_check", id);
		return dealer;
	}

	/* ������ ������ - ���� �� */
	public int getDealerCount() {
		
		return sqlSession.selectOne("Dealer.dealer_count");
	}

	/* ������ ������ - ���� ����Ʈ */
	public List<DealerBean> getDealerList(int page) {

		return sqlSession.selectList("Dealer.dealer_list", page);
	}

	/* ������ ������ - ���� ���� */
	public void editDealer(DealerBean dealerbean) {

		sqlSession.update("Dealer.dealer_edit", dealerbean);
		
	}

	/* ������ ������ - ���� ��� */
	public void insertDealer(DealerBean dealer) {

		sqlSession.insert("Dealer.dealer_reg", dealer);
	}

	/* ������ ������ - ���� ���� */
	public void delDealer(String id) {

		sqlSession.delete("Dealer.dealer_del", id);
	}
	
	/* ���� ������ - ���� ���� */
	public List<CarBean> dealer_car_manage(int page) throws Exception{
		List<CarBean> list = sqlSession.selectList("Dealer.dealer_car_manage", page);
		return list;
	}
	
	/* ���� ������ - ���� �� */
	public int getListCount() throws Exception{
		int count = ((Integer)sqlSession.selectOne("Dealer.list_count")).intValue();
		return count;
	}
	
	/* ���� ������ _ ������� ����(�󼼺���) */
	public CarBean dealer_car_detail(String car_no) throws Exception{
		return (CarBean)sqlSession.selectOne("Dealer.car_detail",car_no);
	}
	
	/* ���� ������ _ ������� ����*/
	public void delete_car(String car_no) throws Exception{
		sqlSession.delete("delete_car",car_no);
	}
	
	/* ������ ������ - ���� ���� ����Ʈ */
	public List<StoreBean> getNameList() throws Exception{
		
		return sqlSession.selectList("Dealer.name_list");
	}

}
