package cn.edu.zust.se.dao;


import cn.edu.zust.se.model.Picture;
import cn.edu.zust.se.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserMapper {
    //添加用户
    @Insert("insert into exp3.user(username,password) values (#{username},#{password})")
    void addUser(@Param("username") String name, @Param("password") String password);

    //删除用户
    @Delete("delete from exp3.user where id=#{id}")
    void deleteUser(@Param("id") int id);

    //修改用户
    @Update("update exp3.user set username=#{username},password=#{password} where id=#{id}")
    void updateUser(@Param("id") int id, @Param("username") String username, @Param("password") String password);

    //列出所有用户
    @Select("select * from exp3.user")
    List<User> getUserList();

    //为用户添加图片
    @Insert("insert into exp3.picture (name,fname,user_id,intro,tags,upload_time) values (#{name},#{fname},#{user_id},#{intro},#{tags},#{upload_time})")
    void addPicture(@Param("name") String username, @Param("fname") String fname, @Param("user_id") int userId, @Param("intro") String intro, @Param("tags") String tags, @Param("upload_time") Date upload_time);

    //列出用户的图片
    @Select("select * from exp3.picture where user_id=#{id}")
    List<Picture> findPicture(@Param("id") int id);

    //关注某个用户
    @Insert("insert into exp3.concern(concerner_id,concerned_id,concern_time) values(#{concerner_id},#{concerned_id},#{concern_time})")
    void concernUser(@Param("concerner_id") int concerner_id, @Param("concerned_id") int concerned_id, @Param("concern_time") Date concern_time);

    //取消关注某个用户
    @Delete("delete from exp3.concern where concerner_id=#{id} and concerned_id=#{concerned_id}")
    void cancelConcern(@Param("id") int id, @Param("concerned_id") int concerned_id);

    //列出用户的粉丝
    @Select("select * from exp3.user,exp3.concern where concerned_id=#{id} and concern.concerner_id=user.id")
    List<User> allConcerner(@Param("id") int id);

    //列出用户关注对象
    @Select("select * from exp3.user,exp3.concern where concerner_id=#{id} and concern.concerned_id=user.id")
    List<User> allConcerned(@Param("id") int id);

    /* ------------------------------------------------------------------------------------------------ */
    @Select("SELECT `user`.* from((SELECT concern.concerned_id FROM concern \n" + "GROUP BY concerned_id ORDER BY  COUNT(*)) as a),`user` \n" + "where `user`.id = a.concerned_id")
    List<User> getBigV();

    @Select("select * from picture where user_id=#{userId} limit #{pageNo},#{pageSize}")
    List<Picture> getUserPictures(@Param("userId") int userId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);


    @Select("SELECT * from picture WHERE DATE(upload_time) < #{end_time} And Date(upload_time) >#{start_time} and user_id = #{user_id} limit #{pageNo},#{pageSize}")
    List<Picture> getUserPicturesTime(@Param("user_id") int user_id, @Param("start_time") Date start_time, @Param("end_time") Date end_time, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);


    @Select("select * from user,concern where concern.concerner_id=#{userId} and concern.concerned_id=user.id")
    List<User> getFollows(int userId);

    @Select("select picture.* from concern,picture where picture.user_id=concerned_id && concerner_id=${userId}")
    List<Picture> getFollowPictures(@Param("userId") int userId, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    @Select("select picture.* from concern,picture where picture.user_id=concerned_id and concerner_id=#{user_id} and  (DATE(upload_time) <=#{end_time} And Date(upload_time) >=#{start_time})")
    List<Picture> getFollowPicturesTime(@Param("user_id") int user_id, @Param("start_time") Date start_time, @Param("end_time") Date end_time, @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    @Select("select * from picture order by upload_time desc limit #{pageNo},#{pageSize}")
    List<Picture> getRecentPictures(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    @Select("select * from user where name like '%${username}%'")
    List<User> findUsersByName(@Param("username") String username);

    @Select("select * from picture where name like '%${picturename}%'")
    List<Picture> findPictureByName(@Param("picturename") String picturename);

    @Select("select * from picture where tags=#{tagname}")
    List<Picture> findPictureByTag(@Param("tagname") String tagname);
}
