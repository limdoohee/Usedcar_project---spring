package com.naver.project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.project.model.*;

@Service("CarService")
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDAOImpl carDAO;
	
	// 두희
	/* 차량 클래스 */
	@Override
	public List<CarBean> searchCarclass()  throws Exception {
		return carDAO.searchCarclass();
	}

	/* 차량 모델 */
	@Override
	public List<CarBean> searchCarmodel(String car_class) throws Exception {
		return carDAO.searchCarmodel(car_class);
	}
	
	/* 전체 검색 */
	@Override
	public List<CarBean> search_alllist() throws Exception {
		return carDAO.search_alllist();
	}
	
	/* 검색 목록 -> 상세 보기 */
	public CarBean search_detail(String car_no) throws Exception {
		return carDAO.search_detail(car_no);
	}
	
	/* 상세보기 -> 딜러정보 */
	public DealerBean dealer_info(String dealer_id)  throws Exception{
		return carDAO.search_dealer_info(dealer_id);
	}
	
	/* 차량 검색 */
	public List<CarBean> searchCarList(CarBean bean) throws Exception{
		return carDAO.searchCarList(bean);
	}
	// 두희
	
	// 지은
	@Override
	public List<CarBean> getCarList(Map m) throws Exception {
		// TODO Auto-generated method stub
		return carDAO.getCarList(m);
	}

	@Override
	public CarBean car_select(String car_no) throws Exception {
		return carDAO.car_select(car_no);
	}

	@Override
	public List<CarBean> getCarList_class(String car_class) {
		return carDAO.getCarList_class(car_class);
	}

	@Override
	public List<CarBean> getCarClassAll() throws Exception {
		return carDAO.getCarClassAll();
	}

	@Override
	public List<CarBean> getCarModelAll(String car_class) throws Exception {
		return carDAO.getCarModelAll(car_class);
	}

	@Override
	public List<CarBean> getCarModelList_filter(Map<String, Double> m) {
		return carDAO.getCarModelList_filter(m);
	}

	@Override
	public CarBean car_calculator(HashMap<String, String> map, CarBean car) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	// 지은
	
	
	//인보
		@Override
		public CarBean car_select1(String car_no) throws Exception {
			return carDAO.car_select1(car_no);
		}

		@Override
		public void insertCarTemp(Car_tempBean Car_tempBean) throws Exception {
			carDAO.insertCarTemp(Car_tempBean);
			
		}

		@Override 
		public List<Car_tempBean> getConfirmList(String temp_car_no) throws Exception {
		  
			return carDAO.getConfirmList(temp_car_no);
		 }

		@Override
		public void insertCar(CarBean CarBean) throws Exception {
			carDAO.insertCar(CarBean);
			
		}
		@Override
		public Car_tempBean checkTemp_car_no(String temp_car_no) throws Exception {
			
			return carDAO.checkTemp_car_no(temp_car_no);
		}

		@Override
		public List<Car_tempBean> getTemp_list(String dealer_id) throws Exception {
			return carDAO.getTemp_list(dealer_id);
			
		}
		
		@Override
		public List<Car_tempBean> getCar_temp_one(String temp_car_no) throws Exception {
			return carDAO.getCar_temp_one(temp_car_no);
			
		}

		@Override
		public List<String> checkTemp_location(Car_tempBean Car_tempBean) throws Exception {
			return carDAO.checkTemp_location(Car_tempBean);
		}

		@Override
		public void updateDealer_id(String dealer_id) throws Exception {
			 carDAO.updateDealer_id(dealer_id);
			
		}

		@Override
		public List<CarBean> getConfirmList2() throws Exception {
			return carDAO.getConfirmList2();
			
		}

		@Override
		public List<CarBean> getCont(String car_no) throws Exception {
			List<CarBean> CarBean = carDAO.getCont(car_no);
			return CarBean;
		}

		@Override
		public void deleteCar(String car_no) throws Exception {
			carDAO.deleteCar(car_no);
		}

		@Override
		public void editCar(CarBean carBean) throws Exception {
			carDAO.editCar(carBean);
			
		}

		@Override
		public void deleteCar_temp(String car_no) throws Exception {
			carDAO.deleteCar_temp(car_no);
			
		}//인보끝
}


