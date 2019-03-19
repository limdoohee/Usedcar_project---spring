package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.project.model.StoreBean;

@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreDAOImpl storeBAO;

	@Override
	public List<StoreBean> getStoreList(int page) throws Exception {
		
		return storeBAO.getStoreList(page);
		
	}
	
	@Override
	public int storeListCount() throws Exception{
		
		return storeBAO.storeListCount();
	}

	@Override
	public void editStore(StoreBean storebean) throws Exception {

		storeBAO.editStore(storebean);
		
	}

	@Override
	public void delStore(int num) throws Exception {
		storeBAO.delStore(num);
		
	}

	@Override
	public int storeSearchCount(Map m) throws Exception {
		
		return storeBAO.storeSearchCount(m);
	}

	@Override
	public List<StoreBean> getStoreSearchList(Map m) throws Exception {
		
		return storeBAO.getStoreSearchList(m);
	}

	@Override
	public void insertStore(StoreBean store) throws Exception{
		storeBAO.insertStore(store);
		
	}

	@Override
	public StoreBean storecheck(int num) throws Exception {
		
		return storeBAO.storecheck(num);
	}
	
	@Override
	// 관리자 페이지 - 전시장 리스트
	public List<StoreBean> adminStoreList(int page) throws Exception{
		return storeBAO.adminStoreList(page);
	}
}
