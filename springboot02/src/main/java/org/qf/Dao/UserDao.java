package org.qf.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.qf.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//用户接口
@Mapper
@Repository
public interface UserDao {
    /**
     * 通过用户名查询用户信息
     * @param name  用户名
     * @return  用户对象
     */
    public  User login(String name);

    /**
     * 查询操作
     * @return
     */
    public List<User> showList(String name);
    /**
     * 根据用户名查询用户
     *
     */
    User getUserByName(String name);

    /**
     * 添加用户
     */
    void addUser(User user);

    //    根据id删除用户
    void deleteUserById(Integer userId);

    //    修改用户
    void updateUser(User user);

    //    批量删除用户
    void deleteBatch(@Param("idList") Integer[] idList);
}
