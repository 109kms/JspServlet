package common;

public class ActionForward {

  private String view;
  private boolean isRedirect;

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
