package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.project.model.CarBean;
import com.naver.project.model.DealerBean;
import com.naver.project.model.DriveBean;
import com.naver.project.model.DriveListResultBean;
import com.naver.project.model.StoreBean;
import com.naver.project.model.Test_dateBean;

@Service("DriveService")
public class DriveServiceImpl implements DriveService {

	@Autowired
	private DriveDAOImpl driveDao;

	@Override
	public List<CarBean> searchCarClass() throws Exception {
		return driveDao.searchCarClass();
	}

	@Override
	public List<CarBean> searchCarModel(String car_class) throws Exception {
		return driveDao.searchCarModel(car_class);
	}

	@Override
	public List<StoreBean> searchStoreLoc1(Map m) throws Exception {
		return driveDao.searchStoreLoc1(m);
	}
	
	@Override
	public List<StoreBean> searchStoreLoc2(Map m) throws Exception {
		return driveDao.searchStoreLoc2(m);
	}

	@Override
	public int getDriveListCount(Map m) throws Exception {
		return driveDao.getDriveListCount(m);
	}

	@Override
	public List<DriveListResultBean> searchDrivelist(Map m) throws Exception {
		return driveDao.selectDrivelist(m);
	}

	@Override
	public DriveListResultBean getDealerInfo(String dealerid) throws Exception {
		return driveDao.getDealerInfo(dealerid);
	}

	@Override
	public List<Test_dateBean> getDrivedate(String car_no) throws Exception {
		return driveDao.getDrivedate(car_no);
	}

	@Override
	public void insertDriveInfo(Map m) throws Exception {
		driveDao.insertDriveInfo(m);
	}

	@Override
	public CarBean getCarInfo(String car_no) throws Exception {
		return driveDao.getCarInfo(car_no);
	}

	@Override
	public DealerBean getStoreNo(String dealer_id) throws Exception {
		return driveDao.getStoreNo(dealer_id);
	}

	@Override
	public void insertTestDate(Map m) throws Exception {
		driveDao.insertTestDate(m);
	}

	@Override
	public int getDealerDriveListCount(Map m) throws Exception {
		return driveDao.getDealerDriveListCount(m);
	}

	@Override
	public List<DriveBean> selectDealerDrivelist(Map m) throws Exception {
		return driveDao.selectDealerDrivelist(m);
	}

	@Override
	public void updateDriveComplete(int drive_no) throws Exception {
		driveDao.updateDriveComplete(drive_no);
	}

	@Override
	public DriveListResultBean getDriveSuccessInfo(Map m) throws Exception {
		return driveDao.getDriveSuccessInfo(m);
	}


}
