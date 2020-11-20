package SERVLET;

import DAO.User;

//定义User用于Servlet的一些操作
public interface UserServlet {
    //登录操作
    public User login(User user);
    //注册操作
    public void regist(User user);
    //判断用户是否存在
    public boolean exist(String username);
}
