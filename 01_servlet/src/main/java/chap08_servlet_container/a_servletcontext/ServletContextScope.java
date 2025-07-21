package chap08_servlet_container.a_servletcontext;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContextScope")

public class ServletContextScope extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /*
     * javax.servlet.ServletContext
     * 
     * 1. 서블릿이 애플리케이션 및 서블릿 컨테이너와 상호작용을 할 수 있도록 해주는 인터페이스입니다.
     * 2. 서블릿이 실행 환경(애플리케이션, 컨테이너)에 대한 정보를 얻을 수 있습니다.
     * 3. 서블릿이 전역 데이터를 저장 및 공유할 수 있습니다.
     * 4. 애플리케이션(컨텍스트)당 하나의 객체만 존재합니다.
     *    ServletContext servletContext = getServletContext();
     * 5. 애플리케이션이 시작할 때 생성되고, 종료할 때 소멸됩니다.
     * 6. 데이터 저장 예시
     *    1) 저장: servletContext.setAttrubute(String key, Object value);
     *    2) 조회: servletContext.getAttribute(String key);
     *    3) 삭제: servletContext.removeAttribute(String key);
     */
    
    //----- ServletContext 객체 얻기
    ServletContext servletContext = getServletContext();
    
    //----- 데이터 저장
    servletContext.setAttribute("data1", 1);
    
    //----- 데이터 조회
    int data1 = (int)servletContext.getAttribute("data1");
    System.out.println(data1);
    
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
