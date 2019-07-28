package lastaccesstime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@WebServlet(name = "LastAccessTime",urlPatterns = "/getlasttime")
public class LastAccessTime extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.当前时间
        Date date = new Date();
        //定义格式
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");
        String currentTime = form.format(date);
        //创建一个cookies 记录当前的最新时间
        Cookie cookie = new Cookie("lastAccessTime", currentTime);
        cookie.setMaxAge(60*24*30);

        response.addCookie(cookie);

        //2.获得客户端携带的cookies
        String lastAccessTime = null;

        Cookie[] cookies = request.getCookies();

        if (cookies!=null){
            for (Cookie cook:cookies){
                if ("lastAccessTime".equals(cook.getName())){
                    lastAccessTime = cook.getValue();

                }
            }
        }
        response.setContentType("text/html;charset=UTF-8");
            if (lastAccessTime==null){
                response.getWriter().write("您是第一次访问");
            }else response.getWriter().write("您上次访问的时间是："+lastAccessTime);
    }
}
