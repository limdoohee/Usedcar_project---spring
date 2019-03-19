package com.naver.project.dao;

import java.util.List;
import java.util.Map;

import com.naver.project.model.StoreBean;

public interface StoreService {
	
	// 전시장 테이블 보이기
	public List<StoreBean> getStoreList(int page) throws Exception;
	
	// 전시장 등록
	public void insertStore(StoreBean store) throws Exception;
	
	// 관리자 페이지 - 전시장 관리 수정
	public void editStore(StoreBean storebean) throws Exception;
		
	// 관리자 페이지 - 전시장 관리 삭제
	public void delStore(int num) throws Exception;

	// 총 전시장 수
	public int storeListCount() throws Exception;
	
	// select 검색 결과 총 전시장 수
	public int storeSearchCount(Map m) throws Exception;
	
	// select 검색 결과 전시장 테이블 보이기
	public List<StoreBean> getStoreSearchList(Map m) throws Exception;

	// 전시장 체크
	public StoreBean storecheck(int num) throws Exception;
	
	// 관리자 페이지 - 전시장 리스트
	public List<StoreBean> adminStoreList(int page) throws Exception;

}
