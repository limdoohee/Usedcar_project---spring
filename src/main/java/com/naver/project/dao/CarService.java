package com.naver.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naver.project.model.BoardBean;
import com.naver.project.model.CarBean;
import com.naver.project.model.Car_tempBean;
import com.naver.project.model.DealerBean;

public interface CarService {
	//두희
	/* 차량 클래스 */
	public List<CarBean> searchCarclass() throws Exception;

	/* 차량 모델 */
	public List<CarBean> searchCarmodel(String car_class) throws Exception;
	
	/* 전체 검색 -> 검색 목록*/
	public List<CarBean> search_alllist() throws Exception;
	
	/* 검색 목록 -> 상세보기 */
	public CarBean search_detail(String car_no) throws Exception;
	
	/* 상세보기 -> 딜러정보 */
	public DealerBean dealer_info(String dealer_id)  throws Exception;
	
	/* 차량 검색 */
	public List<CarBean> searchCarList(CarBean bean) throws Exception;
	// 두희
	
	
	
	//지은
	/*차량  리스트 (실구매계산기) */
	public List<CarBean> getCarList(Map m) throws Exception;
	
	/*차량 디테일 (검색결과->디테일, 실구매계산기->차량선택) */
	public CarBean car_select(String car_no) throws Exception;
	
	/* 실구매계산 */
	public CarBean car_calculator(HashMap<String, String> map, CarBean car) throws Exception;
		
	/* 차량 리스트 - 클래스 선택(실구매 계산기) */
	public List<CarBean> getCarList_class(String car_class);
	
	/*차량 클래스 전체 리스트 */
	public List<CarBean> getCarClassAll() throws Exception;
	
	/*차량 '클래스'에 해당하는 모델 전체 리스트 */
	public List<CarBean> getCarModelAll(String car_class) throws Exception;
	
	/*차량 '필터'에 해당하는 모델 전체 리스트 */
	public List<CarBean> getCarModelList_filter(Map<String, Double> m);
	//지은끝
	
	//인보
		/* 내차 등록 */
		public void insertCarTemp(Car_tempBean Car_tempBean) throws Exception;
		
		/* 내차 등록시 차량번호 중복 확인*/
		public Car_tempBean checkTemp_car_no(String temp_car_no) throws Exception;


		/*딜러 로그인 시 신청 들어온 리스트 보기*/
		public List<Car_tempBean> getTemp_list(String dealer_id) throws Exception;

		public List<Car_tempBean> getCar_temp_one(String temp_car_no) throws Exception;
		
		public List<String> checkTemp_location(Car_tempBean car_tempBean) throws Exception;
		
		/*딜러 아이디 집어넣기*/
		public void updateDealer_id(String dealer_id) throws Exception;
		
		/*딜러 입력사항 확인리스트*/
		public List<CarBean> getConfirmList2() throws Exception;

		/*등록완료차량 내용 상세보기*/
		public List<CarBean> getCont(String car_no) throws Exception;
		
		/*등록완료차량 삭제하기*/
		public void deleteCar(String car_no) throws Exception;

		/*등록완료차량 수정하기*/
		public void editCar(CarBean carBean) throws Exception;
		
		/*카insert*/
		public void insertCar(CarBean carBean) throws Exception;
		

		/*차량번호가져오기*/
		public CarBean car_select1(String car_no) throws Exception;

		/*확인목록*/
		public List<Car_tempBean> getConfirmList(String temp_car_no) throws Exception;
		
		/*딜러 추가사항입력 후 car에 입력되면 car_temp 삭제*/
		public void deleteCar_temp(String car_no) throws Exception;
		
		//인보

	
}
