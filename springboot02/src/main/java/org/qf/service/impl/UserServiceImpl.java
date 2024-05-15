package org.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.qf.Dao.UserDao;
import org.qf.entity.User;
import org.qf.service.UserService;
import org.qf.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//对业务层进行判断
@Service
public class UserServiceImpl implements UserService {

    //业务层：1.调用dao层  2.进行业务层逻辑判断

    @Autowired
    private UserDao userDao;


    @Override  //方法重写
    public ResultVo login(String name, String password) {

        //调用dao层的方法
        User user = userDao.login(name);
        if(user==null){
            //说明用户名 不存在
            return new ResultVo(101,"用户名不存在",null);
        }else{
            //用户名存在
            if(user.getPassword().equals(password)){
                //登录成功
                return new ResultVo(100,"登录成功",user);
            }else{
                return new ResultVo(102,"密码错误",null);
            }
        }
    }

    //查询
    @Override
    public ResultVo showList(String name,int pageNum) {
        //设置页面容量
        PageHelper.startPage(pageNum,5);
        List<User> list = userDao.showList(name);
        PageInfo<User> pageInfo=new PageInfo<User>(list);
        if(pageInfo.getList().size()>0) {
            return new ResultVo(200, "查询成功", pageInfo);
        }else{
            return new ResultVo(201,"查询失败",null);
        }
    }
    /**
     * 添加用户
     * 1. 先根据用户名查询用户是否存在
     * 2. 如果存在，给出错误的提示
     *    如果不存在，插入数据
     */
    @Override
    public ResultVo addUser(User user) {
        User selectUser = userDao.getUserByName(user.getName());
        if(selectUser==null){
            //设置默认密码是123
            user.setPassword("123");
            //可以添加
            userDao.addUser(user);
            return new ResultVo(502,"添加成功",null);
        }else{
            //给出错误提示
            return new ResultVo(501,"用户名已存在",null);
        }
    }

    @Override
    public ResultVo deleteUserById(Integer userId) {
        userDao.deleteUserById(userId);
        return new ResultVo(200,"删除成功",null);
    }

    @Override
    public ResultVo updateUser(User user) {
        userDao.updateUser(user);
        return new ResultVo(200,"编辑成功",null);
    }

    @Override
    public ResultVo deleteBatch(Integer[] idList) {
        //方案一：循环中一个一个删除
//        for(Integer id:idList){
//            userDao.deleteUserById(id);
//        }

        //方案二：利用mybatis的动态SQL实现批量删除
        userDao.deleteBatch(idList);
        return new ResultVo(200,"删除成功",null);
    }
}
