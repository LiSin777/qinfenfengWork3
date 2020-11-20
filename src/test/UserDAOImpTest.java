package test;

import DAO.User;
import DAO.UserDAOImp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOImpTest {

    private UserDAOImp userDAOImp = new UserDAOImp();
    @Test
    void queryUserByUsernameAndPassword() {

    }

    @Test
    void queryUserByUsername() {
        User user = userDAOImp.queryUserByUsername("123");
        System.out.println(user);
    }

    @Test
    void saveUser() {
    }
}