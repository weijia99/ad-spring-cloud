package com.imooc.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class AccessLogFilter extends ZuulFilter {
    @Override
    public String filterType() {
//        这是执行后的操作

        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
//       最后执行
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
//        执行流程，先得到request，在开始的时候设置了时间，然后取出来
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Long startTime = (Long) ctx.get("startTime");

        String uri = request.getRequestURI();

        long duration = System.currentTimeMillis() - startTime;
        log.info(" uri : " + uri + ", duration : " + duration / 100 + "ms");
        return null;
    }
}
