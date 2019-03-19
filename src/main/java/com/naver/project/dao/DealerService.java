package com.naver.project.dao;

import java.util.List;

import com.naver.project.model.CarBean;
import com.naver.project.model.Car_tempBean;
import com.naver.project.model.DealerBean;
import com.naver.project.model.StoreBean;

public interface DealerService {

	/* ������ ������ - ���� ���� */
	public void editDealer(DealerBean dealerbean) throws Exception;
		
	/* ������ ������ - ���� ���� */
	public void delDealer(String id) throws Exception;
	
	/* ������� ��û ���� ��ȸ */
	public List<CarBean> carTemplist(String dealer) throws Exception;
	
	/* ������� ��û ���� ���� */
	public void insertCar(CarBean car) throws Exception;
	
	/* ���� �� ���� �Ǹ����̺��� ���� */
	public void deleteCarTemp(Car_tempBean temp) throws Exception;
	
	/* ����, ������ �α��� üũ */
	public DealerBean dealercheck(String id) throws Exception;

	/* ������ ������ - ���� �� */
	public int getDealerCount();

	/* ������ ������ - ���� ����Ʈ */
	public List<DealerBean> getDealerList(int page);

	/* ������ ������ - ���� ��� */
	public void insertDealer(DealerBean dealer);
	
	/* ���� ������ - ���� ���� */
	public List<CarBean> dealer_car_manage(int page) throws Exception;
	
	/* ���� ������ - ���� �� */
	public int getListCount() throws Exception;

	/* ���� ������ _ ������� ����(�󼼺���) */
	public CarBean dealer_car_detail(String car_no) throws Exception;
	
	/* ���� ������ _ ������� ����*/
	public void delete_car(String car_no) throws Exception;
	
	/* ������ ������ - ���� ���� ����Ʈ */
	public List<StoreBean> getNameList() throws Exception;

}
