package cn.edu.zust.se;

import cn.edu.zust.se.dao.UserMapper;
import cn.edu.zust.se.model.Picture;
import cn.edu.zust.se.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class TestApp {
    @Test
    public void testAddUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        userMapper.addUser("sada", "123");
        System.out.println("添加成功!");
    }
    @Test
    public void testDeleteUser(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        userMapper.deleteUser(28);
        System.out.println("删除成功!");
    }
    @Test
    public void testUpdateUser(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        userMapper.updateUser(1,"yi","0322");
        System.out.println("修改成功!");
    }
    @Test
    public void testGetUserList(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        for (User user : userMapper.getUserList()) {
            System.out.println(user);
        }
    }
    @Test
    public void testAddPicture(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        userMapper.addPicture("yi","fy",1,"21","54",new Date());
        System.out.println("添加成功!");
    }
    @Test
    public void testFindPicture(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        for (Picture picture : userMapper.findPicture(1)) {
            System.out.println(picture);
        }
    }
    @Test
    public void testConcernUser(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        userMapper.concernUser(1,29,new Date());
        System.out.println("关注成功!");
    }
    @Test
    public void testCancelConcern(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        userMapper.cancelConcern(1,29);
        System.out.println("取消关注成功!");
    }
    @Test
    public void testAllConcerner(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        System.out.println(userMapper.allConcerner(29));
    }
    @Test
    public void testAllConcerned(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
        UserMapper userMapper = ac.getBean("userMapper", UserMapper.class);
        System.out.println(userMapper.allConcerned(1));
    }
}
