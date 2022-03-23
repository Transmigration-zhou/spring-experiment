package cn.edu.zust.se.service.impl;

import cn.edu.zust.se.dao.impl.UserDaoImpl;
import cn.edu.zust.se.entity.Tequipment;
import cn.edu.zust.se.entity.Tuser;
import cn.edu.zust.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDaoImpl userDaoImpl;

    @Override
    public void addUser(Tuser tuser) {
        userDaoImpl.add(tuser);
    }

    @Override
    public void addEquipment(Tequipment tequipment) {
        userDaoImpl.addE(tequipment);
    }
}
