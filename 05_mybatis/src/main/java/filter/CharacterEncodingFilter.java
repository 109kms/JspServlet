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

/*
 * @WebFilter 어노테이션은 web.xml의 <filter-mapping> 태그로 대신할 수 있습니다.
 * @WebFilter 어노테이션과 web.xml의 <filter-mapping> 태그가 둘 다 존재하는 경우에는
 * web.xml의 <filter-mapping> 태그가 우선적으로 고려되지만, 실행 순서가 보장되어 있지 않습니다.
 */

// @WebFilter("/*")

public class CharacterEncodingFilter extends HttpFilter implements Filter {

  private String encoding;
  
  @Override
  public void destroy() { }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    request.setCharacterEncoding(encoding);
    response.setContentType("text/html; charset=" + encoding);
    chain.doFilter(request, response);
  }

  @Override
  public void init(FilterConfig fConfig) throws ServletException {
    //----- web.xml의 <filter>태그를 이용해서 encoding값을 전달할 수 있습니다.
    encoding = fConfig.getInitParameter("encoding");
    System.out.println("===== CharacterEncodingFilter : " + encoding + " =====");
    if (encoding == null) {
      encoding = "UTF-8";
    }
  }

}
