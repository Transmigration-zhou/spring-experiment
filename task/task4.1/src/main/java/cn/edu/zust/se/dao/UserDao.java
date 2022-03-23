package cn.edu.zust.se.dao;

import cn.edu.zust.se.entity.Tequipment;
import cn.edu.zust.se.entity.Tuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<Tuser, Integer> {
    @Query("select t from Tuser t where t.login_name = ?1 and t.password = ?2")
    Tuser login(String username, String password);

    @Query("select e from Tequipment e where e.user_id = ?1")
    List<Tequipment> getEquipment(int id);

    @Query("select e from Tequipment e")
    List<Tequipment> getAllEquipment();

    @Query("select t.real_name from Tuser t where t.id= ?1")
    List<Tuser> getName(int id);

    @Query(value = "select id,real_name from tuser group by id having count(*)=1", nativeQuery = true)
    List<Object> getAllUserName();
}
