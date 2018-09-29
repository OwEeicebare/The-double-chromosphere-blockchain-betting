package com.wangchao.icebearbc.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther:WangChao
 * @ClassName:checkLoginFilter
 * @Date:Created in 2018/9/28 16:57
 * @Despriction:
 * @Modify By:
 */
@WebFilter(urlPatterns = {"/user/myUI","/note/add"})
public class checkLoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        Object user = request.getSession().getAttribute("user");
        System.out.println(user+"++++++++++++++++++++++++");
        if (user!=null){
            chain.doFilter(request,response);
        }else {
            response.sendRedirect("/user/loginUI");
        }

    }

    @Override
    public void destroy() {

    }
}
