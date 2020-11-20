package test;

import DAO.User;
import SERVLET.UserServletImp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServletImpTest {
    private UserServletImp userServletImp = new UserServletImp();
    @Test
    void login() {
        User user = new User("liqing", "123456", "liqing@qq.com");
        User login = userServletImp.login(user);
        System.out.println(login);
    }

    @Test
    void regist() {
    }

    @Test
    void exist() {
        boolean b = userServletImp.exist("123");
        System.out.println(b);
    }
}