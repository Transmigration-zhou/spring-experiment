package org.itee.se.demo.Service;

import org.apache.log4j.Logger;
import org.itee.se.demo.pojo.User;
import org.itee.se.demo.pojo.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Autowired
    private UserCache cache;

    @Override
    public boolean login(String userName, String password) {
        cache.setUserName(userName);
        cache.setLoginTime(new Date());
        logger.info("登录人:" + cache.getUserName() + ",登录时间:" + cache.getLoginTime());
        return true;
    }

    @Override
    public boolean logout() {
        Date date1 = cache.getLoginTime();
        Date date2 = new Date();
        long time = date2.getTime() - date1.getTime();
        logger.info("登录人:" + cache.getUserName() + ",本次使用时间:" + time + "ms");
        cache.setUserName(null);
        cache.setLoginTime(null);
        return true;
    }

    @Override
    public void addUser(User user) {
        logger.info("增加了一个用户");
    }

    @Override
    public void updateUser(User user) {
        logger.info("更新了一个用户");
    }

    @Override
    public void deleteUser(User user) {
        logger.info("删除了一个用户");
    }
}
