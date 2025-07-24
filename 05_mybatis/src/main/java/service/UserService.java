package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public interface UserService {
  ActionForward login(HttpServletRequest request);
  ActionForward logout(HttpServletRequest request);
}
