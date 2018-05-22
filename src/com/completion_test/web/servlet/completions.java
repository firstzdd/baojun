package com.completion_test.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.completion_test.domain.completion;
import com.completion_test.service.impl.completion_testServiceImpl;

public class completions extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset = utf-8");
		completion asdfCompletion = new completion();
		asdfCompletion.setRequest_uri(request.getRequestURI());
		asdfCompletion.setRequest_method(request.getMethod());
		String responsestr = "默认响应:"+request.getMethod()+request.getRequestURI();
		asdfCompletion.setResponse_body(responsestr);
		completion_testServiceImpl testServiceImpl = new completion_testServiceImpl();
		completion compl = testServiceImpl.findUserByUsername(request.getMethod(),request.getRequestURI());
		if (compl != null) {
			PrintWriter out = response.getWriter();//得到一个字符输出流
			out.write(compl.getResponse_body());//向客户端响应文本内容
			out.close();
		}else {
			testServiceImpl.insert(asdfCompletion);
			PrintWriter out = response.getWriter();//得到一个字符输出流
			out.write(asdfCompletion.getResponse_body());//向客户端响应文本内容
			out.close();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

	
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}
	
	
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

		
	}
	
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);

	}
	
	
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
	
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
	
	

}
