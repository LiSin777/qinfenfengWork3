package WEB;

import DAO.User;
import SERVLET.UserServletImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Test;

import java.io.IOException;

import java.io.IOException;

//用户注册Servlet
@WebServlet("/${Entity_Name}")
public class RegistServlet extends HttpServlet {
    //用户Servlet操作类
    private UserServletImp userServletImp = new UserServletImp();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前段表单项的用户名,密码,email
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        //判断用户是否存在
        if(userServletImp.exist(username)){
            request.setAttribute("message" , "用户已注册");
            //存在就跳转报错页面
            request.getRequestDispatcher("/Messages/message.jsp").forward(request , response);
        }else {
            //不存在就可以注册了
            User user = new User(username, password, email);
            userServletImp.regist(user);

            request.setAttribute("message" , "注册成功");
            //注册成功就跳转去登录
            request.getRequestDispatcher("/Messages/message2.jsp").forward(request , response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
