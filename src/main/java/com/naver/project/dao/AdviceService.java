package com.naver.project.dao;

import java.util.List;

import com.naver.project.model.AdviceBean;

public interface AdviceService {
	

/* ���� ������_����û���� */
public List<AdviceBean> dealer_Counsel(AdviceBean advice) throws Exception;

/* ����û */
public void insertCounsel(AdviceBean advice) throws Exception;

}
