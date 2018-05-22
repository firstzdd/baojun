package com.completion_test.service;

import com.completion_test.domain.completion;
import com.completion_test.domain.completion_test;


public interface completion_testService {


	
		public int addcompletion_test(completion_test clent) throws Exception;
		
		completion findUserByUsername(String request_method, String request_uri);
		
		
		
		int insert(completion comp);
		/**
		 * 请求完录入响应体
		 * @return 
		 */
		void updateResponse_bodyById(completion_test compl);
		
		
}
