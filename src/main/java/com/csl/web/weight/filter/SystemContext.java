package com.csl.web.weight.filter;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

public class SystemContext {
    private static ThreadLocal<HttpServletRequest> REQUEST = new ThreadLocal<HttpServletRequest>();
    private static ThreadLocal<HttpServletResponse> RESPONSE = new ThreadLocal<HttpServletResponse>();
    private static Gson gson = new Gson();

    public static HttpServletRequest getRequest() {
	return REQUEST.get();
    }

    public static ServletContext getServletContext() {
	return getSession().getServletContext();
    }

    public static void setRequest(HttpServletRequest request) {
	REQUEST.set(request);
    };

    public static HttpServletResponse getResponse() {
	return RESPONSE.get();
    }

    public static void setResponse(HttpServletResponse response) {
	RESPONSE.set(response);
    };

    public static HttpSession getSession() {
	return getRequest().getSession();
    }

    public static void outputJson(Object obj) throws IOException {
	HttpServletResponse response = RESPONSE.get();
	response.setCharacterEncoding("UTF-8");
	response.setContentType("application/json");
	String json = gson.toJson(obj);
	response.getOutputStream().write(json.getBytes("UTF-8"));
	response.getOutputStream().flush();
    }

}