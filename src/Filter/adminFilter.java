package Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
//对admin中的文件访问进行过滤,不允许非用户直接访问
public class adminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        //看是否有用户登录成功
        Object user = session.getAttribute("user");
        System.out.println((String) user);
        if(user == null){
            servletRequest.getRequestDispatcher("/Messages/message6.jsp").forward(servletRequest , servletResponse);
        }else {
            filterChain.doFilter(servletRequest , servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
