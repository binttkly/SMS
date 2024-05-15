package org.qf.service;
//业务层接口 成功返回true或者数据

import org.qf.entity.User;
import org.qf.utils.ResultVo;

public interface UserService {
    /**
     * 登录功能
     * @param name
     * @param password
     * @return
     */
    public ResultVo login(String name, String password);

    /**
     * 查询
     * @param name
     * @return
     */
    public ResultVo showList(String name,int pageNum);

    /**
     * 添加用户
     * @param user
     * @return
     */
    ResultVo addUser(User user);

    ResultVo deleteUserById(Integer userId);

    ResultVo updateUser(User user);

    ResultVo deleteBatch(Integer[] idList);
}

