package com.naver.project.dao;

import java.util.List;

import com.naver.project.model.AdviceBean;

public interface AdviceService {
	

/* 딜러 페이지_상담신청관리 */
public List<AdviceBean> dealer_Counsel(AdviceBean advice) throws Exception;

/* 상담신청 */
public void insertCounsel(AdviceBean advice) throws Exception;

}
