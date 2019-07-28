package cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cookiestext",urlPatterns = "/cookies")
public class cookiestext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookies对象
        Cookie cookie = new Cookie("name","cook1");

        //为cookies设置持久化时间
        cookie.setMaxAge(10 * 60);

       //设置cookies携带路径
        cookie.setPath("/getcookies");

        //将cookies信息返回给客户端

        response.addCookie(cookie);

    }
}
