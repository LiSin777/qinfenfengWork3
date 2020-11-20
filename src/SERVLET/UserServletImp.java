package SERVLET;

import DAO.User;
import DAO.UserDAOImp;

//实现类
public class UserServletImp implements UserServlet{
    private UserDAOImp userDAOImp = new UserDAOImp();
    @Override
    public User login(User user) {
        //数据库有这个对应用户就返回没有就为null
        return userDAOImp.queryUserByUsernameAndPassword(user.getUsername() , user.getPassword());
    }

    @Override
    public void regist(User user) {
        //保存到数据库中
        userDAOImp.saveUser(user);
    }

    @Override
    public boolean exist(String username) {
        User user = userDAOImp.queryUserByUsername(username);
        if(user == null){
            return false;
        }
        return true;
    }
}
