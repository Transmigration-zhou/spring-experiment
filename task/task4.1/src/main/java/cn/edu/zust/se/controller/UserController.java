package cn.edu.zust.se.controller;

import cn.edu.zust.se.dao.UserDao;
import cn.edu.zust.se.dao.impl.UserDaoImpl;
import cn.edu.zust.se.entity.Tequipment;
import cn.edu.zust.se.entity.Tuser;
import cn.edu.zust.se.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao tuserDao;
    @Autowired
    private UserDaoImpl tuserDaoImpl;
    @Autowired
    private UserService userService;

    //打开用户登陆页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    //用户登录表单提交
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@RequestParam("login_name") String login_name, @RequestParam("password") String password, HttpSession session, Model model) {
        Tuser tuser = UserDao.login(login_name,password);
        session.setAttribute("tuser",tuser);
        List<Tequipment> tequipmentList= tuserDao.getEquipment(tuser.getId());
        model.addAttribute("tequipmentList",tequipmentList);
        List<Tequipment> tAllequipment = tuserDao.getAllEquipment();
        List<Object> allUserName = tuserDao.getAllUserName();
        List<String> userName = new ArrayList<>();
        for(Tequipment e:tAllequipment){
            userName.add(String.valueOf(tuserDao.getName(e.getUser_id())));
        }
        model.addAttribute("tAllequipmentList",tAllequipment);
        model.addAttribute("equipmentName",userName);
        model.addAttribute("allUserName",allUserName);
        if(userDaoImpl.signUp(login_name,password)==1){
            return "userHome";
        }
        if(userDaoImpl.signUp(login_name,password)==0){
            return "adminHome";
        }
    }

    //打开注册页面
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(@RequestParam("login_name") String login_name, @RequestParam("password") String password, HttpSession session, Model model) {


        return "register";
    }

    //用户登录表单提交
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String doRegister(UserDto user) {
//
//    }
}
