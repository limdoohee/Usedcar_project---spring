package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import com.naver.project.model.StoreBean;

public interface StoreService {
	
	// ������ ���̺� ���̱�
	public List<StoreBean> getStoreList(int page) throws Exception;
	
	// ������ ���
	public void insertStore(StoreBean store) throws Exception;
	
	// ������ ������ - ������ ���� ����
	public void editStore(StoreBean storebean) throws Exception;
		
	// ������ ������ - ������ ���� ����
	public void delStore(int num) throws Exception;

	// �� ������ ��
	public int storeListCount() throws Exception;
	
	// select �˻� ��� �� ������ ��
	public int storeSearchCount(Map m) throws Exception;
	
	// select �˻� ��� ������ ���̺� ���̱�
	public List<StoreBean> getStoreSearchList(Map m) throws Exception;

	// ������ üũ
	public StoreBean storecheck(int num) throws Exception;
	
	// ������ ������ - ������ ����Ʈ
	public List<StoreBean> adminStoreList(int page) throws Exception;

}
