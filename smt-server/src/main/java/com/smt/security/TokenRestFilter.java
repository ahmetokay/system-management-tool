package com.smt.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.WebUtils;

@Component
public class TokenRestFilter extends GenericFilterBean {

  private Logger logger = LoggerFactory.getLogger(TokenRestFilter.class);

  private TokenManager tokenManager;

  @Autowired
  public TokenRestFilter(TokenManager tokenManager) {
    this.tokenManager = tokenManager;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    Cookie tokenCookie = WebUtils.getCookie((HttpServletRequest) request, SmtTokenConfig.TOKEN_KEY);
    if (tokenCookie == null) {
      if (((HttpServletRequest) request).getServletPath().equals("/smt_login/login")) {
        chain.doFilter(request, response);
      }
      ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
    } else {
      chain.doFilter(request, response);
    }

    //chain.doFilter(request, response);
  }
}