package DAO;

//操作user表的接口,用于定义操作user表的方法,用于以后方便拓张功能
public interface UserDAO {
    //通过用户名和密码查找对应的用户
    public User queryUserByUsernameAndPassword(String username , String password);
    //通过用户名查找用户
    public User queryUserByUsername(String username);
    //保存用户到数据库
    public int saveUser(User user);
}
