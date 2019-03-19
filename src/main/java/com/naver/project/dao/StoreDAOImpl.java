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

	/* 전시장 리스트 */
	public List<StoreBean> getStoreList(int page) {
		
		return sqlSession.selectList("Store.store_list", page);
	}

	/* 전시장 수 */
	public int storeListCount() {
		
		return sqlSession.selectOne("Store.store_count");
	}

	/* 검색 결과 전시장 수 */
	public int storeSearchCount(Map m) {
		int count = 0;
		count = ((Integer) sqlSession.selectOne("Store.store_search_count", m)).intValue();
		return count;
	}

	/* 검색 결과 전시장 리스트 */
	public List<StoreBean> getStoreSearchList(Map m) {
		
		return sqlSession.selectList("Store.store_search_list", m);
	}

	/* 관리자 페이지 - 전시장 등록 */
	public void insertStore(StoreBean store) {
		sqlSession.insert("Store.store_reg", store);
		
	}

	/* 전시장 체크 */
	public StoreBean storecheck(int num) {
		return sqlSession.selectOne("Store.store_check", num);
	}

	/* 관리자 페이지 - 전시장 수정 */
	public void editStore(StoreBean storebean) {

		sqlSession.update("Store.store_edit", storebean);
		
	}

	/* 관리자 페이지 - 전시장 삭제 */
	public void delStore(int num) {

		sqlSession.delete("Store.store_del", num);
		
	}
	
	/* 관리자 페이지 - 전시장 리스트 */
	public List<StoreBean> adminStoreList(int page) {
		return sqlSession.selectList("Store.adminStoreList", page);
	}

}
