package com.dlaq.oa.basic.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class BaseController {
	
	protected void outWriteJSON(HttpServletResponse res, String json) {
		outWrite(res, json, "application/json");
	}
	protected void outWrite(HttpServletResponse res, String msg, String contentType) {
		res.setContentType(contentType);
		try {
			PrintWriter out = res.getWriter();
			out.write(msg);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
