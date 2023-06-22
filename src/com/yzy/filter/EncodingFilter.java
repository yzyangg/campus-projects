package com.yzy.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/6/21 22:53
 */
public class EncodingFilter implements Filter {
    String encoding = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);

        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public void destroy() {

    }
}
