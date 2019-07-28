package cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "getCookiesTest",urlPatterns = "/getcookies")
public class getCookiesTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获得客户端携带的cookies的数据
        Cookie[] cookies = request.getCookies();

        //通过cookies的名字获得想要的cookies
        for (Cookie cookie : cookies) {
            //获得cookies的名称
            String cookieName = cookie.getName();
            if (cookieName.equals("name")) {
                //获得该cookies的值
                String cookValue = cookie.getValue();
                response.getWriter().write(cookieName);
            }
        }
    }
}
