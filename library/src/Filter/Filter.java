package Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
/*
    private String encode="UTF-8";

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode=filterConfig.getInitParameter("encode");
        if(encode==null)
            encode="UTF-8";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest )servletRequest;
        HttpServletResponse response=(HttpServletResponse )servletResponse;
        //判断请求方式是否为post
        if("POST".equalsIgnoreCase(request.getMethod())){
            //设置字符编码
            request.setCharacterEncoding(encode);
            //设置响应类型
            response.setCharacterEncoding(encode);
            response.setContentType("text/html;charset="+encode);
            //将请求与响应传递给下个过滤器
            filterChain.doFilter(request,response);
            //结束
        }
    }
*/
    private static String encoding; // 定义变量接收初始化的值
    public void destroy() {}
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 设置字符编码链锁
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        chain.doFilter(request, response);
    }
    // 初始化
    public void init(FilterConfig config) throws ServletException {
        // 接收web.xml配置文件中的初始参数
        encoding = config.getInitParameter("CharsetEncoding");
    }

}









