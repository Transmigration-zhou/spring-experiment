package cn.edu.zust.se.service;

import cn.edu.zust.se.dao.UserMapper;
import cn.edu.zust.se.model.Picture;
import cn.edu.zust.se.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getBigV() {
        return userMapper.getBigV();
    }

    @Override
    public List<Picture> getUserPictures(int userId, int pageNo, int pageSize) {
        pageNo = (pageNo - 1) * pageSize;
        return userMapper.getUserPictures(userId, pageNo, pageSize);
    }

    @Override
    public List<Picture> getUserPictures(int userId, Date start_time, Date end_time, int pageNo, int pageSize) {
        if (start_time == null) {
            start_time = new Date(0);
        }
        if (end_time == null) {
            end_time = new Date();
        }
        pageNo = (pageNo - 1) * pageSize;
        return userMapper.getUserPicturesTime(userId, start_time, end_time, pageNo, pageSize);
    }

    @Override
    public List<User> getFollows(int userId) {
        return userMapper.getFollows(userId);
    }

    @Override
    public List<Picture> getFollowPictures(int userId, int pageNo, int pageSize) {
        pageNo = (pageNo - 1) * pageSize;
        return userMapper.getFollowPictures(userId, pageNo, pageSize);
    }

    @Override
    public List<Picture> getFollowPictures(int userId, Date start_time, Date end_time, int pageNo, int pageSize) {
        pageNo = (pageNo - 1) * pageSize;
        return userMapper.getFollowPicturesTime(userId, start_time, end_time, pageNo, pageSize);
    }

    @Override
    public List<Picture> getRecentPictures(int pageNo, int pageSize) {
        pageNo = (pageNo - 1) * pageSize;
        return userMapper.getRecentPictures(pageNo, pageSize);
    }

    @Override
    public List<User> findUsersByName(String username) {
        return userMapper.findUsersByName(username);
    }

    @Override
    public List<Picture> findPictureByName(String picturename) {
        return userMapper.findPictureByName(picturename);
    }

    @Override
    public List<Picture> findPictureByTag(String tagname) {
        return userMapper.findPictureByTag(tagname);
    }

}
