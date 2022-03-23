import cn.edu.zust.se.model.Picture;
import cn.edu.zust.se.model.User;
import cn.edu.zust.se.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserMapperTest {
    @Autowired
    ApplicationContext ac = new ClassPathXmlApplicationContext("mybatis.xml");
    UserService userServiceImpl = ac.getBean("userServiceImpl", UserService.class);

    //1.大V排行榜，粉丝最多的10个人
    @Test
    public void testgetBigV() {
        List<User> users = userServiceImpl.getBigV();
        System.out.println(users);
    }

    //2.分页获取指定用户的照片
    @Test
    public void testgetUserPictures() {
        List<Picture> pictures = userServiceImpl.getUserPictures(7, 1, 3);
        System.out.println(pictures);
    }

    //3.分页获取指定用户指定时间段内发布的照片，当start_time为空时表示开始时间不限，end_time为空时表示到当前时间
    @Test
    public void testgetUserPicturess() {
        List<Picture> pictures = userServiceImpl.getUserPictures(7, null, null, 1, 3);
        System.out.println(pictures);
    }

    @Test
    //4获取指定用户关注的用户
    public void testgetFollows() {
        List<User> users = userServiceImpl.getFollows(1);
        System.out.println(users);
    }

    //5.分页获取指定用户关注的用户照片
    @Test
    public void testgetFollowPictures() {
        List<Picture> pictures = userServiceImpl.getFollowPictures(2, 1, 3);
        System.out.println(pictures);
    }

    //6.分页获取指定用户关注的用户在指定时间段的照片
    @Test
    public void testgetFollowPicturess() {
        List<Picture> pictures = userServiceImpl.getFollowPictures(7, null, null, 1, 3);
        System.out.println(pictures);
    }


    //7.分页获取系统中最新上传的照片
    @Test
    public void testgetRecentPictures() {
        List<Picture> pictures = userServiceImpl.getRecentPictures(1, 3);
        System.out.println(pictures);
    }


    //8.根据用户名模糊查询用户
    @Test
    public void testfindUsersByName() {
        List<User> users = userServiceImpl.findUsersByName("u");
        System.out.println(users);
    }

    //9.根据照片名模糊查询照片信息
    @Test
    public void testfindPictureByName() {
        List<Picture> pictures = userServiceImpl.findPictureByName("i");
        System.out.println(pictures);
    }

    //10.根据照片的标签信息查询照片
    @Test
    public void testfindPictureByTag() {
        List<Picture> pictures = userServiceImpl.findPictureByTag("1");
        System.out.println(pictures);
    }
}