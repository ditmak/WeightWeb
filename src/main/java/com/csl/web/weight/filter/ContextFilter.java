package com.csl.web.weight.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 实现线程级别保存request和response，session方便以后调用
 *
 * @author v-songlechen 时间：2014上午9:59:45
 *
 */
public class ContextFilter implements Filter {
    private Logger log = Logger.getLogger(ContextFilter.class);

    /**
     * Default constructor.
     */
    public ContextFilter() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {

    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain chain) throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) request;
	SystemContext.setRequest(req);
	SystemContext.setResponse((HttpServletResponse) response);
	chain.doFilter(request, response);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
