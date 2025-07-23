package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("*.do")

public class BoardFilter extends HttpFilter implements Filter {

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    
    // 요청 인코딩
    HttpServletRequest req = (HttpServletRequest) request;
    req.setCharacterEncoding("UTF-8");
    
    System.out.println("필터왔다.");
    
    // 필터 동작 후 서블릿 실행
    chain.doFilter(request, response);

  }

}
