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

	/* �� Ŭ���� ��ȸ */
	public List<CarBean> searchCarClass() throws Exception;
	
	/* �� �� ��ȸ */
	public List<CarBean> searchCarModel(String car_class) throws Exception;

	/* ������ ����1 ��ȸ */
	public List<StoreBean> searchStoreLoc1(Map m) throws Exception;
	
	/* ������ ����2 ��ȸ */
	public List<StoreBean> searchStoreLoc2(Map m) throws Exception;
	
	/* �ý� ���� ����Ʈ ī��Ʈ ��ȸ */
	public int getDriveListCount(Map m) throws Exception;
	
	/* �ý� ���� ����Ʈ ��ȸ */
	public List<DriveListResultBean> searchDrivelist(Map m) throws Exception;

	/* ���� ���� ��ȸ */
	public DriveListResultBean getDealerInfo(String dealerid) throws Exception;

	/* �ý� �ð��� ���� */
	public List<Test_dateBean> getDrivedate(String car_no) throws Exception;
		
	/* �ý½�û���� �Է� */
	public void insertDriveInfo(Map m) throws Exception;

	/* �� Ŭ����, �� ��ȸ */
	public CarBean getCarInfo(String car_no) throws Exception;

	/* ������ ��ȣ ��ȸ */
	public DealerBean getStoreNo(String dealer_id) throws Exception;

	/* test_date ���̺� �߰� */
	public void insertTestDate(Map m) throws Exception;

	/* �ý� ��û���� Ȯ�� */
	public DriveListResultBean getDriveSuccessInfo(Map m) throws Exception;

	
	// ���� ������
	/* �ý½�û ����Ʈ ī��Ʈ ��ȸ */
	public int getDealerDriveListCount(Map m) throws Exception;

	/* �ý½�û ����Ʈ ��ȸ	 */
	public List<DriveBean> selectDealerDrivelist(Map m) throws Exception;

	/* �ý� �Ϸ� ó�� */
	public void updateDriveComplete(int drive_no) throws Exception;




}
