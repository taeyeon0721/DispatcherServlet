package ctrl;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncFilter
 */
@WebFilter("*.do") // 모든 요청에 대해 이 곳을 방문하게 하기
public class EncFilter extends HttpFilter implements Filter {
       
	private String encoding;
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding(this.encoding); // 하드코딩 > web.xml에 저장돼있던 초기화 매개변수로 교체
		System.out.println("로그: 인코딩 UTF-8 doFilter() 정상실행");

		// pass the request along the filter chain
		chain.doFilter(request, response); // 아무일도 없었던 것처럼 다시 진행해
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException { // 처음 동작할 때 세팅하는 함수
		// TODO Auto-generated method stub
		System.out.println("로그: init() 정상실행");
		this.encoding = fConfig.getServletContext().getInitParameter("encoding"); // web.xml에 초기화 매개변수로 지정했던 거 호출
		
	}

}
