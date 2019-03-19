package com.naver.project.dao;

import java.util.List;

import com.naver.project.model.CarBean;
import com.naver.project.model.Car_tempBean;
import com.naver.project.model.DealerBean;
import com.naver.project.model.StoreBean;

public interface DealerService {

	/* 관리자 페이지 - 딜러 수정 */
	public void editDealer(DealerBean dealerbean) throws Exception;
		
	/* 관리자 페이지 - 딜러 삭제 */
	public void delDealer(String id) throws Exception;
	
	/* 차량등록 신청 내역 조회 */
	public List<CarBean> carTemplist(String dealer) throws Exception;
	
	/* 차량등록 신청 내역 승인 */
	public void insertCar(CarBean car) throws Exception;
	
	/* 승인 후 내차 판매테이블에서 삭제 */
	public void deleteCarTemp(Car_tempBean temp) throws Exception;
	
	/* 딜러, 관리자 로그인 체크 */
	public DealerBean dealercheck(String id) throws Exception;

	/* 관리자 페이지 - 딜러 수 */
	public int getDealerCount();

	/* 관리자 페이지 - 딜러 리스트 */
	public List<DealerBean> getDealerList(int page);

	/* 관리자 페이지 - 딜러 등록 */
	public void insertDealer(DealerBean dealer);
	
	/* 딜러 페이지 - 차량 관리 */
	public List<CarBean> dealer_car_manage(int page) throws Exception;
	
	/* 딜러 페이지 - 차량 수 */
	public int getListCount() throws Exception;

	/* 딜러 페이지 _ 등록차량 관리(상세보기) */
	public CarBean dealer_car_detail(String car_no) throws Exception;
	
	/* 딜러 페이지 _ 등록차량 삭제*/
	public void delete_car(String car_no) throws Exception;
	
	/* 관리자 페이지 - 딜러 지점 리스트 */
	public List<StoreBean> getNameList() throws Exception;

}
