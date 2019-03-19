package com.naver.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.project.model.AdviceBean;

@Service("AdviceService")
public class AdviceServiceImpl implements AdviceService {

	@Autowired
	private AdviceDAOImpl adviceDAO;

	@Override
	public List<AdviceBean> dealer_Counsel(AdviceBean advice) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCounsel(AdviceBean advice) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
