package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.project.model.StoreBean;

@Repository
public class StoreDAOImpl {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	/* ������ ����Ʈ */
	public List<StoreBean> getStoreList(int page) {
		
		return sqlSession.selectList("Store.store_list", page);
	}

	/* ������ �� */
	public int storeListCount() {
		
		return sqlSession.selectOne("Store.store_count");
	}

	/* �˻� ��� ������ �� */
	public int storeSearchCount(Map m) {
		int count = 0;
		count = ((Integer) sqlSession.selectOne("Store.store_search_count", m)).intValue();
		return count;
	}

	/* �˻� ��� ������ ����Ʈ */
	public List<StoreBean> getStoreSearchList(Map m) {
		
		return sqlSession.selectList("Store.store_search_list", m);
	}

	/* ������ ������ - ������ ��� */
	public void insertStore(StoreBean store) {
		sqlSession.insert("Store.store_reg", store);
		
	}

	/* ������ üũ */
	public StoreBean storecheck(int num) {
		return sqlSession.selectOne("Store.store_check", num);
	}

	/* ������ ������ - ������ ���� */
	public void editStore(StoreBean storebean) {

		sqlSession.update("Store.store_edit", storebean);
		
	}

	/* ������ ������ - ������ ���� */
	public void delStore(int num) {

		sqlSession.delete("Store.store_del", num);
		
	}
	
	/* ������ ������ - ������ ����Ʈ */
	public List<StoreBean> adminStoreList(int page) {
		return sqlSession.selectList("Store.adminStoreList", page);
	}

}
