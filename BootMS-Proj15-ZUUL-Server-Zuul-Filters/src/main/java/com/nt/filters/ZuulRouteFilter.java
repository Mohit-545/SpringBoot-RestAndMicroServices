//ZuulRouteFilter.java
package com.nt.filters;



import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZuulRouteFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		//return true to enable filtering
		return true;
	}//method

	@Override
	public Object run() throws ZuulException {
		// Get RequestContext object (it gets access to multiple other objects)
		RequestContext context = RequestContext.getCurrentContext();
		System.out.println("ZuulRouteFilter.run() method executed");
		// Writing log messages about current request 
		log.info("========From ROUTE Filter========");
		log.info("Router Host  :: "+context.getRequest().getRemoteHost());
		return null;
	}//method

	@Override
	public String filterType() {
		// make this filter as ROUTE Filter
		return FilterConstants.ROUTE_TYPE;
	}//method

	@Override
	public int filterOrder() {
		// make this filter as high priority filter 
		return 0;
	}//method

}//class
