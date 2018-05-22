package com.completion_test.dao;

import com.completion_test.domain.completion;
import com.completion_test.domain.completion_test;

public interface completion_testDao {
	
	/**
	 * ��ӱ�����Ϣ
	 * @param user
	 * @throws Exception
	 */
	public int addcompletion_test(completion_test clent) throws Exception;
	
	//判断是否配置表是否有数据
	completion selectRequestBodyByRequest(String request_method,String request_uri);
	
	//没有数据就插入
	int addRequestBody(completion compl);
	
	public void updateResponseBodyById(completion_test compl);


}
