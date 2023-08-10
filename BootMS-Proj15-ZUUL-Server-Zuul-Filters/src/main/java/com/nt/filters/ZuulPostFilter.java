//ZuulPostFilter.java
package com.nt.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulPostFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		//return true to enable filtering
		return true;
	}//method

	@Override
	public Object run() throws ZuulException {
		// Get RequestContext object (it gets access to multiple other objects)
		RequestContext context = RequestContext.getCurrentContext();
		// Get HttpServletResponse object from this context ojbect
		HttpServletResponse res = context.getResponse();
		System.out.println("ZuulPostFilter.run() method executed");
		// Writing log messages about current request 
		log.info("========From POST Filter========");
		log.info("Response Content Type :: "+res.getContentType());
		log.info("Response Status :: "+res.getStatus());
		log.info("Response Host Name :: "+res.getHeader("host"));
		
		return null;
	}//method

	@Override
	public String filterType() {
		// make this filter as POST Filter
		return FilterConstants.POST_TYPE;
	}//method

	@Override
	public int filterOrder() {
		// make this filter as high priority filter 
		return 0;
	}//method

}//class
