package com.smt.security;

import com.smt.config.SmtTokenConfig;
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
    if (((HttpServletRequest) request).getServletPath().equals("/smt_login")
        || ((HttpServletRequest) request).getServletPath().equals("/smt_register")) {
      chain.doFilter(request, response);
      return;
    }

    Cookie tokenCookie = WebUtils.getCookie((HttpServletRequest) request, SmtTokenConfig.TOKEN_KEY);
    if (tokenCookie == null) {
      ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
    } else {
      // get token from cookie and check from cache system
      if (!tokenManager.check(tokenCookie.getValue())) {
        ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
      } else {
        chain.doFilter(request, response);
      }
    }
  }
}