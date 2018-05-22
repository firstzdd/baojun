package com.completion_test.web.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.completion_test.domain.completion_test;
import com.completion_test.service.impl.completion_testServiceImpl;
import com.completion_test.util.UUIDUtil;

public class completion_testServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;Charset = utf-8");
		
		String strmet = request.getMethod();
		completion_test clent = new completion_test();
		clent.setRequest_method(strmet);
		clent.setRequest_uri(request.getRequestURI());
		String str1 = "";
		if (strmet.equals("GET")) {
			str1 = request.getQueryString();
		}else {
			BufferedReader br = request.getReader();
			String str = "";
			while((str = br.readLine()) != null){
			str1 += str;
			}
		}
		clent.setRequest_body(str1);
		clent.setUser_agent(request.getHeader("User-Agent"));
		clent.setContent_type(request.getContentType());
		clent.setCreate_time(new Date());
		//
		//String responsestr = request.getMethod();
		//response.getWriter().write(responsestr);
		clent.setId(UUIDUtil.getUUID());
		completion_testServiceImpl cts = new completion_testServiceImpl();
		//操作xml响应
		StringBuffer xml = new StringBuffer();
		try {
			int i = cts.addcompletion_test(clent);
			if (i>0) {
				xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		        xml.append("<response>\n");
		        xml.append("<success>1</success>\n");
		        xml.append("<failmailnums></failmailnums>\n");
		        xml.append("<remark></remark>\n");
		        xml.append("</response>");
		        clent.setResponse_body(xml.toString());
		        cts.updateResponse_bodyById(clent);
				PrintWriter out = response.getWriter();//得到一个字符输出流
				out.write("success:"+xml.toString()+"插入数据成功");//向客户端响应文本内容
				out.close();
			} else {
				PrintWriter out = response.getWriter();//得到一个字符输出流
				out.write("插入数据失败1");//向客户端响应文本内容
				out.close();
			}
		} catch (Exception e) {
			PrintWriter out = response.getWriter();//得到一个字符输出流
			out.write("插入数据失败");//向客户端响应文本内容
			out.close();
			e.printStackTrace();
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
