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

	/* ������ ������ - ���� �� */
	@Override
	public int getDealerCount() {
		
		return dealerDAO.getDealerCount();
	}

	/* ������ ������ - ���� ����Ʈ */
	@Override
	public List<DealerBean> getDealerList(int page) {
		
		return dealerDAO.getDealerList(page);
	}

	/* ������ ������ - ���� ��� */
	@Override
	public void insertDealer(DealerBean dealer) {
		dealerDAO.insertDealer(dealer);
	}

	/* ���� ������ - ���� ���� */
	public List<CarBean> dealer_car_manage(int page) throws Exception{
		return dealerDAO.dealer_car_manage(page);
	}
	
	/* ���� ������ - ���� �� */
	public int getListCount() throws Exception{
		return dealerDAO.getListCount();
	}
	
	/* ���� ������ _ ������� ����(�󼼺���) */
	public CarBean dealer_car_detail(String car_no) throws Exception{
		return dealerDAO.dealer_car_detail(car_no);
	}
	
	/* ���� ������ _ ������� ����*/
	public void delete_car(String car_no) throws Exception{
		dealerDAO.delete_car(car_no);
	}
	
	/* ������ ������ - ���� ���� ����Ʈ */
	@Override
	public List<StoreBean> getNameList() throws Exception {
	
		return dealerDAO.getNameList();
	}
}
