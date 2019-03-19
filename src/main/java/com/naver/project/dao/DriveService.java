package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;
import com.naver.project.model.DriveBean;
import com.naver.project.model.DriveListResultBean;
import com.naver.project.model.StoreBean;
import com.naver.project.model.Test_dateBean;

public interface DriveService {

	/* 차 클래스 조회 */
	public List<CarBean> searchCarClass() throws Exception;
	
	/* 차 모델 조회 */
	public List<CarBean> searchCarModel(String car_class) throws Exception;

	/* 전시장 지역1 조회 */
	public List<StoreBean> searchStoreLoc1(Map m) throws Exception;
	
	/* 전시장 지역2 조회 */
	public List<StoreBean> searchStoreLoc2(Map m) throws Exception;
	
	/* 시승 차량 리스트 카운트 조회 */
	public int getDriveListCount(Map m) throws Exception;
	
	/* 시승 차량 리스트 조회 */
	public List<DriveListResultBean> searchDrivelist(Map m) throws Exception;

	/* 딜러 정보 조회 */
	public DriveListResultBean getDealerInfo(String dealerid) throws Exception;

	/* 시승 시간대 선택 */
	public List<Test_dateBean> getDrivedate(String car_no) throws Exception;
		
	/* 시승신청정보 입력 */
	public void insertDriveInfo(Map m) throws Exception;

	/* 차 클래스, 모델 조회 */
	public CarBean getCarInfo(String car_no) throws Exception;

	/* 전시장 번호 조회 */
	public DealerBean getStoreNo(String dealer_id) throws Exception;

	/* test_date 테이블에 추가 */
	public void insertTestDate(Map m) throws Exception;

	/* 시승 신청정보 확인 */
	public DriveListResultBean getDriveSuccessInfo(Map m) throws Exception;

	
	// 딜러 페이지
	/* 시승신청 리스트 카운트 조회 */
	public int getDealerDriveListCount(Map m) throws Exception;

	/* 시승신청 리스트 조회	 */
	public List<DriveBean> selectDealerDrivelist(Map m) throws Exception;

	/* 시승 완료 처리 */
	public void updateDriveComplete(int drive_no) throws Exception;




}
