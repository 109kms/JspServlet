package controller;

/**
 * 어디로 이동할 것인지 정보를 view에 저장하고,
 * 어떻게 이동할 것인지 정보를 isRedirect에 저장하는 클래스
 */
public class ActionForward {

  private String view;  //--------- 이동할 JSP/Servlet 경로
  private boolean isRedirect;  //-- true이면 redirect, false이면 forward
  
  public ActionForward() {}

  public ActionForward(String view, boolean isRedirect) {
    super();
    this.view = view;
    this.isRedirect = isRedirect;
  }

  public String getView() {
    return view;
  }

  public void setView(String view) {
    this.view = view;
  }

  public boolean isRedirect() {
    return isRedirect;
  }

  public void setRedirect(boolean isRedirect) {
    this.isRedirect = isRedirect;
  }
  
  
}
