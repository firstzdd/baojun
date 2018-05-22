package com.completion_test.service.impl;

import com.completion_test.dao.impl.completion_testDaoImpl;
import com.completion_test.domain.completion;
import com.completion_test.domain.completion_test;
import com.completion_test.service.completion_testService;

public class completion_testServiceImpl implements completion_testService {
	// 
	private completion_testDaoImpl clentDao = new completion_testDaoImpl();

	public int addcompletion_test(completion_test clent) throws Exception {
		
		return clentDao.addcompletion_test(clent);
		
	}

	public completion findUserByUsername(String request_method, String request_uri) {
		
		return clentDao.selectRequestBodyByRequest(request_method, request_uri);
	}

	public int insert(completion comp) {
		
		return clentDao.addRequestBody(comp);
	}

	
	public void updateResponse_bodyById(completion_test compl) {
		
		clentDao.updateResponseBodyById(compl);
	}
}
	
	
