package com.naver.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.project.model.CarBean;
import com.naver.project.model.Car_tempBean;
import com.naver.project.model.DealerBean;
import com.naver.project.model.StoreBean;

@Service("DealerService")
public class DealerServiceImpl implements DealerService {
	
	@Autowired
	private DealerDAOImpl dealerDAO;

	@Override
	public void editDealer(DealerBean dealerbean) throws Exception {
		dealerDAO.editDealer(dealerbean);
		
	}

	@Override
	public void delDealer(String id) throws Exception {
		dealerDAO.delDealer(id);
	}

	@Override
	public List<CarBean> carTemplist(String dealer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCar(CarBean car) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCarTemp(Car_tempBean temp) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DealerBean dealercheck(String id) throws Exception {
		return dealerDAO.dealercheck(id);
	}

	/* 관리자 페이지 - 딜러 수 */
	@Override
	public int getDealerCount() {
		
		return dealerDAO.getDealerCount();
	}

	/* 관리자 페이지 - 딜러 리스트 */
	@Override
	public List<DealerBean> getDealerList(int page) {
		
		return dealerDAO.getDealerList(page);
	}

	/* 관리자 페이지 - 딜러 등록 */
	@Override
	public void insertDealer(DealerBean dealer) {
		dealerDAO.insertDealer(dealer);
	}

	/* 딜러 페이지 - 차량 관리 */
	public List<CarBean> dealer_car_manage(int page) throws Exception{
		return dealerDAO.dealer_car_manage(page);
	}
	
	/* 딜러 페이지 - 차량 수 */
	public int getListCount() throws Exception{
		return dealerDAO.getListCount();
	}
	
	/* 딜러 페이지 _ 등록차량 관리(상세보기) */
	public CarBean dealer_car_detail(String car_no) throws Exception{
		return dealerDAO.dealer_car_detail(car_no);
	}
	
	/* 딜러 페이지 _ 등록차량 삭제*/
	public void delete_car(String car_no) throws Exception{
		dealerDAO.delete_car(car_no);
	}
	
	/* 관리자 페이지 - 딜러 지점 리스트 */
	@Override
	public List<StoreBean> getNameList() throws Exception {
	
		return dealerDAO.getNameList();
	}
}
