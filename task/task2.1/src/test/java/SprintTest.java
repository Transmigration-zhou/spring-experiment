import org.itee.se.demo.pojo.User;
import org.itee.se.demo.Service.UserServiceI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SprintTest {
    @Autowired
    private UserServiceI userService;
    @Test
    public void testLogin() {
        assertTrue(userService.login("gy", "0410"));
    }

    @Test
    public void testLogout() {
        assertTrue(userService.logout());
    }

    @Test
    public void testAddUser() {
        userService.addUser(new User());
    }

    @Test
    public void testUpdateUser() {
        userService.updateUser(new User());
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser(new User());
    }
}
