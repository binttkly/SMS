package org.qf.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.qf.entity.User1;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户接口： 接口interface修饰
 * 接口中的方法都是抽象方法，抽象方法：没有方法体也就是没有方法实现
 * 抽象方法是由abstract修饰的
 *
 *
 * 方法的语法： 访问修饰符 返回值类型 方法名(参数可选){}
 */
@Mapper
@Repository
public interface UserDao {

    /**
     * 通过用户名查询用户信息
     * @param name  用户名
     * @return  用户对象
     */
    public User1 login(String name);

    /**
     * 查询操作
     * @return
     */
    public List<User1> showList(String name);

    /**
     * 根据用户名查询用户
     *
     */
    User1 getUserByName(String name);

    /**
     * 添加用户
     */
    void addUser(User1 user);

//    根据id删除用户
    void deleteUserById(Integer userId);

//    修改用户
    void updateUser(User1 user);

//    批量删除用户
    void deleteBatch(@Param("idList") Integer[] idList);
}
