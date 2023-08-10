//ZuulPreFilter.java
package com.nt.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulPreFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		//return true to enable filtering
		return true;
	}//method

	@Override
	public Object run() throws ZuulException {
		// Get RequestContext object (it gets access to multiple other objects)
		RequestContext context = RequestContext.getCurrentContext();
		// Get HttpServletRequest object from this context ojbect
		HttpServletRequest req = context.getRequest();
		System.out.println("ZuulPreFilter.run() method executed");
		// Writing log messages about current request 
		log.info("========From PRE Filter========");
		log.info("Request Content Type :: "+req.getContentType());
		log.info("Request mode :: "+req.getMethod());
		log.info("Request Path :: "+req.getServletPath());
		log.info("Request URI :: "+req.getRequestURI());
		return null;
	}//method

	@Override
	public String filterType() {
		// make this filter as PRE Filter
		return FilterConstants.PRE_TYPE;
	}//method

	@Override
	public int filterOrder() {
		// make this filter as high priority filter 
		return 0;
	}//method

}//class
