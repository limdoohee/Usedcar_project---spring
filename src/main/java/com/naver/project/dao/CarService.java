package com.naver.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.naver.project.model.BoardBean;
import com.naver.project.model.CarBean;
import com.naver.project.model.Car_tempBean;
import com.naver.project.model.DealerBean;

public interface CarService {
	//����
	/* ���� Ŭ���� */
	public List<CarBean> searchCarclass() throws Exception;

	/* ���� �� */
	public List<CarBean> searchCarmodel(String car_class) throws Exception;
	
	/* ��ü �˻� -> �˻� ���*/
	public List<CarBean> search_alllist() throws Exception;
	
	/* �˻� ��� -> �󼼺��� */
	public CarBean search_detail(String car_no) throws Exception;
	
	/* �󼼺��� -> �������� */
	public DealerBean dealer_info(String dealer_id)  throws Exception;
	
	/* ���� �˻� */
	public List<CarBean> searchCarList(CarBean bean) throws Exception;
	// ����
	
	
	
	//����
	/*����  ����Ʈ (�Ǳ��Ű���) */
	public List<CarBean> getCarList(Map m) throws Exception;
	
	/*���� ������ (�˻����->������, �Ǳ��Ű���->��������) */
	public CarBean car_select(String car_no) throws Exception;
	
	/* �Ǳ��Ű�� */
	public CarBean car_calculator(HashMap<String, String> map, CarBean car) throws Exception;
		
	/* ���� ����Ʈ - Ŭ���� ����(�Ǳ��� ����) */
	public List<CarBean> getCarList_class(String car_class);
	
	/*���� Ŭ���� ��ü ����Ʈ */
	public List<CarBean> getCarClassAll() throws Exception;
	
	/*���� 'Ŭ����'�� �ش��ϴ� �� ��ü ����Ʈ */
	public List<CarBean> getCarModelAll(String car_class) throws Exception;
	
	/*���� '����'�� �ش��ϴ� �� ��ü ����Ʈ */
	public List<CarBean> getCarModelList_filter(Map<String, Double> m);
	//������
	
	//�κ�
		/* ���� ��� */
		public void insertCarTemp(Car_tempBean Car_tempBean) throws Exception;
		
		/* ���� ��Ͻ� ������ȣ �ߺ� Ȯ��*/
		public Car_tempBean checkTemp_car_no(String temp_car_no) throws Exception;


		/*���� �α��� �� ��û ���� ����Ʈ ����*/
		public List<Car_tempBean> getTemp_list(String dealer_id) throws Exception;

		public List<Car_tempBean> getCar_temp_one(String temp_car_no) throws Exception;
		
		public List<String> checkTemp_location(Car_tempBean car_tempBean) throws Exception;
		
		/*���� ���̵� ����ֱ�*/
		public void updateDealer_id(String dealer_id) throws Exception;
		
		/*���� �Է»��� Ȯ�θ���Ʈ*/
		public List<CarBean> getConfirmList2() throws Exception;

		/*��ϿϷ����� ���� �󼼺���*/
		public List<CarBean> getCont(String car_no) throws Exception;
		
		/*��ϿϷ����� �����ϱ�*/
		public void deleteCar(String car_no) throws Exception;

		/*��ϿϷ����� �����ϱ�*/
		public void editCar(CarBean carBean) throws Exception;
		
		/*īinsert*/
		public void insertCar(CarBean carBean) throws Exception;
		

		/*������ȣ��������*/
		public CarBean car_select1(String car_no) throws Exception;

		/*Ȯ�θ��*/
		public List<Car_tempBean> getConfirmList(String temp_car_no) throws Exception;
		
		/*���� �߰������Է� �� car�� �ԷµǸ� car_temp ����*/
		public void deleteCar_temp(String car_no) throws Exception;
		
		//�κ�

	
}
