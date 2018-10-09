package com.wangchao.icebearbc.filter;


import com.wangchao.icebearbc.bean.User;
import com.wangchao.icebearbc.server.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther:WangChao
 * @ClassName:AutoLoginFilter
 * @Date:Created in 2018/10/9 17:18
 * @Despriction:自动登录逻辑的过滤器
 * @Modify By:
 */
@WebFilter("/*")
public class AutoLoginFilter implements Filter {
    @Autowired
    private UserServiceImpl userService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        //为了避免重复登录
        if (request.getSession().getAttribute("user")!=null) {
            chain.doFilter(request,response);
            return;
        }

        Cookie[] cookies = request.getCookies();//拿到cookies
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("autologin")){
                    String value = cookie.getValue();
                    String[] split = value.split("#");
                    String username = split[0];
                    String password = split[1];

                    User user = userService.dologin(username, password);
                    request.getSession().setAttribute("user",user);
                }
            }
        }

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
