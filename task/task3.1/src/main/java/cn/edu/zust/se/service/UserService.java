package cn.edu.zust.se.service;

import cn.edu.zust.se.model.Picture;
import cn.edu.zust.se.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface UserService {
    List<User> getBigV();
    List<Picture> getUserPictures(int userId,int pageNo,int pageSize);
    List<Picture> getUserPictures(int userId, Date start_time, Date end_time, int pageNo, int pageSize);
    List<User> getFollows(int userId);
    List<Picture> getFollowPictures(int userId,int pageNo,int pageSize);
    List<Picture> getFollowPictures(int usereId,Date start_time,Date end_time,int pageNo,int pageSize);
    List<Picture> getRecentPictures(int pageNo,int pageSize);
    List<User> findUsersByName(String username);
    List<Picture> findPictureByName(String picturename);
    List<Picture> findPictureByTag(String tagname);
}
