package chap05_async;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/XmlResponse")
public class XmlResponse extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //----- 전국 주요 도시 날씨 현황(1시간마다 자동 갱신)
    String apiURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
    
    //----- 접속 링크 생성
    URL url = new URL(apiURL);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    
    //----- 문자 기반 입력 스트림 선언
    BufferedReader in = null;
    
    //----- API 응답 결과에 따른 입력 스트림 in 생성
    if (con.getResponseCode() == 200) {
      in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    } else {
      in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
      System.out.println("aaa");
    }
    
    //----- 한 줄씩 읽어(String line) 모으기(StringBuilder sb)
    String line = null;
    StringBuilder sb = new StringBuilder();
    while ((line = in.readLine()) != null) {
      sb.append(line);
    }
    
    //----- 사용이 끝난 입력 스트림 닫기
    in.close();
    
    //----- StringBuilder sb에 저장된 내용을 응답
    response.setHeader("Content-Type", "application/xml; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.write(sb.toString());
    out.close();

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }

}
