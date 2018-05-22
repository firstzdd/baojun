package com.completion_test.dao.impl;

import java.sql.Timestamp;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.completion_test.dao.completion_testDao;
import com.completion_test.domain.completion;
import com.completion_test.domain.completion_test;
import com.completion_test.util.C3P0Util;

public class completion_testDaoImpl implements completion_testDao {

	private QueryRunner qr = new QueryRunner(C3P0Util.getDataSource(), true);
	public int addcompletion_test(completion_test clent) throws Exception {
		
		
		try {
			return qr.update("INSERT INTO COMPLETION_TEST VALUES(?,?,?,?,?,?,?,?)", clent.getRequest_method(),
					clent.getRequest_uri(), clent.getRequest_body(), clent.getResponse_body(), clent.getUser_agent(),
					clent.getContent_type(), new Timestamp(clent.getCreate_time().getTime()),clent.getId());
		} catch(Exception e){
			return 0;
		}
	}

	


	public completion selectRequestBodyByRequest(String request_method, String request_uri) {
		try{
			return qr.query("SELECT * FROM COMPLETION WHERE REQUEST_METHOD=? AND REQUEST_URI =?",
					new BeanHandler<completion>(completion.class), request_method, request_uri);
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	public int addRequestBody(completion compl) {
		try {
			return qr.update("INSERT INTO COMPLETION VALUES(?,?,?)", compl.getRequest_method(), compl.getRequest_uri(),
					compl.getResponse_body());
		} catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	
	public void updateResponseBodyById(completion_test compl) {
		
		
		try{
			qr.update("update COMPLETION_TEST set response_body=? where id=?",
					compl.getResponse_body(),compl.getId());
		
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	

}
