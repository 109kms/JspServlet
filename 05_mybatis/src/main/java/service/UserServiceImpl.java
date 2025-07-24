package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import dao.UserDao;
import model.dto.UserDTO;

public class UserServiceImpl implements UserService {

  private UserDao userDao = UserDao.getInstance();
  
  @Override
  public ActionForward login(HttpServletRequest request) {

    //----- email, password 받기
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    //----- email, password를 가진 UserDTO 객체 생성
    UserDTO user = new UserDTO();
    user.setEmail(email);
    user.setPassword(password);
    
    //----- 사용자 조회
    UserDTO foundUser = userDao.getUser(user);
    
    //----- foundUser가 존재하면 "로그인 처리" 수행, 아니면 로그인 화면으로 이동
    String view = null;
    ActionForward af;
    
    if (foundUser != null) {
      HttpSession session = request.getSession();
      session.setAttribute("loginUser", foundUser);
      view = "/main";
      af = new ActionForward(request.getContextPath() + view, true);
    } else {
      request.setAttribute("error", "아이디나 비밀번호를 확인하세요");
      view = "/view/user/login.jsp";
      af = new ActionForward(view, false);
    }
    
    return af;
  }

  @Override
  public ActionForward logout(HttpServletRequest request) {

    //----- 세션 초기화
    request.getSession().invalidate();
    
    //----- 메인 화면(/index.jsp)으로 리다이렉트
    return new ActionForward(request.getContextPath() + "/main", true);
    
  }

}
