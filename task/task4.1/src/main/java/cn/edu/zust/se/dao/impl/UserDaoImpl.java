package cn.edu.zust.se.dao.impl;

import cn.edu.zust.se.entity.Tequipment;
import cn.edu.zust.se.entity.Tuser;
import cn.edu.zust.se.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Repository("UserDaoImpl")
public class UserDaoImpl {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    UserDao userDao;

    public int signUp(String username, String password) {
        if (userDao.login(username, password) != null) {
            if (userDao.login(username, password).getType() == 1) {
                return 1;
            }
        }
        return 0;
    }

    public void add(Tuser user) {
        entityManager.persist(user);
    }

    public void addE(Tequipment tequipment) {
        Date date = new Date();
        tequipment.setAdd_time(date);
        entityManager.persist(tequipment);
    }
}
