package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.project.model.CarBean;
import com.naver.project.model.Car_tempBean;
import com.naver.project.model.DealerBean;

@Repository
public class CarDAOImpl {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//두희
	/* 차량 클래스 */
	public List<CarBean> searchCarclass()  throws Exception {
		 List<CarBean> carclass = sqlSession.selectList("Car.car_class");
		 return carclass;
	}

	/* 차량 모델 */
	public List<CarBean> searchCarmodel(String car_class) {
		List<CarBean> carmodel = sqlSession.selectList("Car.car_model", car_class);
		return carmodel;
	}
	
	/* 차량 검색 */
	public List<CarBean> searchCarList(CarBean bean) {
		List<CarBean> list = sqlSession.selectList("Car.car_list", bean);
		return list;
	}

	/* 전체 검색 */
	public List<CarBean> search_alllist() {
		List<CarBean> list = sqlSession.selectList("Car.car_alllist");
		return list;
	}
	
	/* 상세 보기 */
	public CarBean search_detail(String car_no) {
		CarBean list = (CarBean)sqlSession.selectOne("Car.car_detail",car_no);
		return list;
	}
	
	/* 상세보기 -> 딜러정보 */
	public DealerBean search_dealer_info(String dealer_id) {
		DealerBean dealer = sqlSession.selectOne("Car.dealer_info",dealer_id);
		return dealer;
	}
	//두희
	
	//지은
	public List<CarBean> getCarList(Map m) {
		return sqlSession.selectList("Car.car_list2", m);
	}

	public List<CarBean> getCarList_class(String car_class) {
		return sqlSession.selectList("Car.car_list2", car_class);
	}
	
	public List<CarBean> getCarClassAll() {
		return sqlSession.selectList("Car.car_class2");
	}

	public List<CarBean> getCarModelAll(String car_class) {
		return sqlSession.selectList("Car.car_model2", car_class);
	}

	public CarBean car_select(String car_no) {
		return sqlSession.selectOne("Car.car_detail", car_no);
	}

	public List<CarBean> getCarModelList_filter(Map<String, Double> m) {
		return sqlSession.selectList("Car.car_list_filter",m);
	}
	//지은끝
	
	
	//인보
		public List<CarBean> getConfirmList2(){
		List<CarBean> confirmList2 =
		 sqlSession.selectList("confirmList2");
		return confirmList2;
		}
		
		public void insertCarTemp(Car_tempBean Car_tempBean) throws Exception{
			sqlSession.insert("temp_insert",Car_tempBean);
			
		}
		
		  public List<Car_tempBean> getConfirmList(String temp_car_no) {
		 List<Car_tempBean> confirmList =
		  sqlSession.selectList("confirmList",temp_car_no);
		 return confirmList;
		 }

		public Car_tempBean checkTemp_car_no(String temp_car_no) throws Exception {
			Car_tempBean checkTemp_car_no=
					(Car_tempBean)sqlSession.selectOne("checkTemp_car_no", temp_car_no);
			return checkTemp_car_no;
		}

		public List<Car_tempBean> getTemp_list(String dealer_id) {
			List<Car_tempBean>  getTemp_list=
			sqlSession.selectList("getTemp_list",dealer_id);
			return getTemp_list;
		}
		
		public List<Car_tempBean> getCar_temp_one(String temp_car_no){
			List<Car_tempBean> getCar_temp_one =
					sqlSession.selectList("getCar_temp_one", temp_car_no);
			return getCar_temp_one;
					
		}

		public List<String> checkTemp_location(Car_tempBean car_tempBean)throws Exception  {
			List<String> checkTemp_location =
					sqlSession.selectList("temp_location",car_tempBean);
			return checkTemp_location;
		}

		public void updateDealer_id(String dealer_id) throws Exception {
			sqlSession.update("updateDealer_id",dealer_id);
		}

		public void insertCar(CarBean CarBean)  throws Exception{
			sqlSession.insert("car_insert",CarBean);
			
		}

		public List<CarBean> getCont(String car_no) {
			List<CarBean> CarBean = sqlSession.selectList("car_cont",car_no);
			return CarBean;
		}

		public void deleteCar(String car_no) {
			sqlSession.delete("deleteCar",car_no);
			
		}

		public void editCar(CarBean carBean) {
			sqlSession.update("editCar",carBean);
			
		}

		public CarBean car_select1(String car_no) {
			return sqlSession.selectOne("select_car", car_no);
		}

		public void deleteCar_temp(String car_no) {
			sqlSession.delete("deleteCar_temp",car_no);
			
		}


		public List<Car_tempBean> getCont2(String car_no) {
			
			return sqlSession.selectList("getCont2",car_no);
		}

		//인보
}
