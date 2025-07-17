package chap01_request;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestExServlet
 */
@WebServlet("/RequestExServlet")  //----- 서블릿 호출(요청)을 위한 주소
public class RequestExServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  
	  String name = request.getParameter("name");
	  String email = request.getParameter("email");
	  System.out.println(name + email);
	  
	  String gender = request.getParameter("gender");
	  System.out.println(gender);
	  
	  String[] hobbies = request.getParameterValues("hobbies");
	  System.out.println(Arrays.toString(hobbies));
	  
	  String[] mobile = request.getParameterValues("mobile");
	  System.out.println(Arrays.toString(mobile) );

	}

}
