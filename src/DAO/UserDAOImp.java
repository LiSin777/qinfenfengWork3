package DAO;

//实现类
public class UserDAOImp extends BaseDAO implements UserDAO {
    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        return queryOne(User.class , sql , username , password);
    }

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from user where username = ?";
        return queryOne(User.class , sql , username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(username , password , email) values(? , ? , ?)";
        return update(sql , user.getUsername() , user.getPassword() , user.getEmail());
    }
}
