package chap06_file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  //----- 다운로드 해야 할 파일명과 전체 경로
	  String filename = request.getParameter("filename");
	  String filePath = "C:/storage/" + filename;
	  
	  //----- 다운로드 파일의 정보를 확인할 수 있는 File 객체
	  File file = new File(filePath);
	  
	  //----- 다운로드 파일의 정보가 없으면 다운로드 불가 응답
	  if ( !file.exists() || file.isDirectory()) {
	    response.setHeader("Content-Type", "text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    out.println("<script>alert('파일이 존재하지 않습니다.')</script>");
	    out.close();
	    return;
	  }
	  
	  //----- 다운로드 응답
	  
	  //----- 다운로드 응답 헤더 구성
	  String originFilename = URLEncoder.encode(filename.substring(filename.indexOf("_") + 1), "UTF-8").replaceAll("\\+", "%20") ;
	  response.setHeader("Content-Disposition", "attachment; filename=\"" + originFilename + "\"");  //----- 자동으로 다운로드 할 파일 이름을 지정
	  response.setHeader("Content-Type", "application/octet-stream");  //----- 응답 데이터는 binary data (파일 자체)
	  response.setHeader("Content-Length", file.length() + "");  //----- 다운로드 해 줄 파일 크기
	  
	  //----- 서버에 저장된 파일을 읽어서 그대로 응답하기
	  try (
	      BufferedInputStream in = new BufferedInputStream( new FileInputStream(file) );  //--------- 서버에 저장된 파일을 읽는 입력 스트림
	      BufferedOutputStream out = new BufferedOutputStream( response.getOutputStream() );  //----- 응답 출력 스트림
	  ){
      
	    byte[] b = new byte[1024];
	    int readByte = 0;
	    while ((readByte = in.read(b)) != -1) {
	      out.write(b, 0, readByte);
	    }
	    
    } 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
