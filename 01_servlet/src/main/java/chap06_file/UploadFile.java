package chap06_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadFile")
@MultipartConfig(
    location = "C:/storage",  //-------- 업로드 파일을 저장할 디렉터리 경로
    maxFileSize = 1024 * 1024 * 10  //-- 크기를 10MB 제한
    )

public class UploadFile extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //----- 업로드 한 파일을 저장할 디렉터리 만들기
    File dir = new File("C:/storage");
    if (!dir.exists()) {
      dir.mkdirs();
    }

    //----- 업로드 실행
    Part part = request.getPart("file");
    String filename = System.currentTimeMillis() + "_" + part.getSubmittedFileName();  //----- 타임스탬프 + 밑줄 + 첨부된 파일명
    part.write(filename);

    //----- 응답
    response.setHeader("Content-Type", "text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<div>");

    out.println("<div>원래파일명 : " + part.getSubmittedFileName() + "</div>");
    out.println("<div>저장파일명: " + filename + "</div>");
    out.println("<hr>");

    //----- 업로드 디렉터리에 저장된 모든 파일 가져와서 응답
    out.println("<div>저장된 파일 목록</div>");
    File[] files = dir.listFiles();
    for (File file : files) {
      String storedFilename = file.getName();  //----- 타임스탬프 + 밑줄 + 첨부된 파일명
      String originFilename = file.getName().substring(file.getName().indexOf("_") + 1);
      out.println("<div><a href=\"/01_servlet/DownloadFile?filename=" + URLEncoder.encode(storedFilename, "UTF-8") + "\">" + originFilename + "</a></div>");
    }
    out.println("<button type='button' onclick='history.back()'><-back</button>");
    out.close();

  }

}
