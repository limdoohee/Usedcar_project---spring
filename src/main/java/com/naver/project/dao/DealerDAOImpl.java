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

	/* 딜러, 관리자 로그인 체크 */
	public DealerBean dealercheck(String id) {
		
		DealerBean dealer = (DealerBean) sqlSession.selectOne("Dealer.dealer_admin_check", id);
		return dealer;
	}

	/* 관리자 페이지 - 딜러 수 */
	public int getDealerCount() {
		
		return sqlSession.selectOne("Dealer.dealer_count");
	}

	/* 관리자 페이지 - 딜러 리스트 */
	public List<DealerBean> getDealerList(int page) {

		return sqlSession.selectList("Dealer.dealer_list", page);
	}

	/* 관리자 페이지 - 딜러 수정 */
	public void editDealer(DealerBean dealerbean) {

		sqlSession.update("Dealer.dealer_edit", dealerbean);
		
	}

	/* 관리자 페이지 - 딜러 등록 */
	public void insertDealer(DealerBean dealer) {

		sqlSession.insert("Dealer.dealer_reg", dealer);
	}

	/* 관리자 페이지 - 딜러 삭제 */
	public void delDealer(String id) {

		sqlSession.delete("Dealer.dealer_del", id);
	}
	
	/* 딜러 페이지 - 차량 관리 */
	public List<CarBean> dealer_car_manage(int page) throws Exception{
		List<CarBean> list = sqlSession.selectList("Dealer.dealer_car_manage", page);
		return list;
	}
	
	/* 딜러 페이지 - 차량 수 */
	public int getListCount() throws Exception{
		int count = ((Integer)sqlSession.selectOne("Dealer.list_count")).intValue();
		return count;
	}
	
	/* 딜러 페이지 _ 등록차량 관리(상세보기) */
	public CarBean dealer_car_detail(String car_no) throws Exception{
		return (CarBean)sqlSession.selectOne("Dealer.car_detail",car_no);
	}
	
	/* 딜러 페이지 _ 등록차량 삭제*/
	public void delete_car(String car_no) throws Exception{
		sqlSession.delete("delete_car",car_no);
	}
	
	/* 관리자 페이지 - 딜러 지점 리스트 */
	public List<StoreBean> getNameList() throws Exception{
		
		return sqlSession.selectList("Dealer.name_list");
	}

}
