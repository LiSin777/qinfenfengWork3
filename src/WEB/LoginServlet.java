package WEB;

import DAO.User;
import SERVLET.UserServletImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//登录Servlet
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //老样子,为了避免之后出错加着就完事
        resp.setContentType("text/html ; setchar = utf-8");
        resp.setCharacterEncoding("utf-8");

        UserServletImp userServletImp = new UserServletImp();
        //获取用户登录的表单项数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User(username, password, email);

        if(userServletImp.login(user) != null){
            //如果登陆成功就进入上传页面
            req.getRequestDispatcher("upload.html").forward(req , resp);
        }else{
            //失败就跳转重新登录
            req.setAttribute("message" , "用户名或密码错误");
            req.getRequestDispatcher("/Messages/message3.jsp").forward(req , resp);
        }

    }
}
