package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;
import com.naver.project.model.DriveBean;
import com.naver.project.model.DriveListResultBean;
import com.naver.project.model.StoreBean;
import com.naver.project.model.Test_dateBean;

@Repository
public class DriveDAOImpl {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<CarBean> searchCarClass() throws Exception {
		List<CarBean> list = sqlSession.selectList("Drive.searchCarClass");
		return list;
	}

	public List<CarBean> searchCarModel(String car_class) throws Exception {
		List<CarBean> list = sqlSession.selectList("Drive.searchCarModel", car_class);
		return list;
	}

	public List<StoreBean> searchStoreLoc1(Map m) throws Exception {
		List<StoreBean> list = sqlSession.selectList("Drive.searchStoreLoc1", m);
		return list;
	}

	public List<StoreBean> searchStoreLoc2(Map m) throws Exception {
		List<StoreBean> list = sqlSession.selectList("Drive.searchStoreLoc2", m);
		return list;
	}

	public int getDriveListCount(Map m) throws Exception {
		int count = ((Integer)sqlSession.selectOne("Drive.getDriveListCount", m)).intValue();
		return count;
	}

	public List<DriveListResultBean> selectDrivelist(Map m) throws Exception {
		List<DriveListResultBean> list = sqlSession.selectList("Drive.selectDrivelist", m);
		return list;
	}

	public DriveListResultBean getDealerInfo(String dealerid) throws Exception {
		return (DriveListResultBean) sqlSession.selectOne("Drive.getDealerInfo", dealerid);
	}

	public List<Test_dateBean> getTestToday() throws Exception {
		return sqlSession.selectList("Drive.getTestToday");
	}

	public String getDriveMonth() throws Exception {
		return sqlSession.selectOne("Drive.getDriveMonth");
	}

	public CarBean getCarInfo(String car_no) throws Exception {
		return sqlSession.selectOne("Drive.getCarInfo", car_no);
	}

	public void insertDriveInfo(Map m) throws Exception {
		sqlSession.insert("Drive.insertDriveInfo", m);
	}

	public DealerBean getStoreNo(String dealer_id) throws Exception {
		return sqlSession.selectOne("Drive.getStoreNo", dealer_id);
	}

	public void insertTestDate(Map m) throws Exception {
		sqlSession.insert("Drive.insertTestDate", m);
	}

	public List<Test_dateBean> getDrivedate(String car_no) throws Exception {
		return sqlSession.selectList("Drive.getDrivedate", car_no);
	}

	public int getDealerDriveListCount(Map m) throws Exception {
		int count = ((Integer)sqlSession.selectOne("Drive.getDealerDriveListCount", m)).intValue();
		return count;
	}

	public List<DriveBean> selectDealerDrivelist(Map m) throws Exception {
		return sqlSession.selectList("Drive.selectDealerDrivelist", m);
	}

	public void updateDriveComplete(int drive_no) throws Exception {
		sqlSession.update("Drive.updateDriveComplete", drive_no);
	}

	public DriveListResultBean getDriveSuccessInfo(Map m) throws Exception {
		return sqlSession.selectOne("Drive.getDriveSuccessInfo", m);
	}
	
}
