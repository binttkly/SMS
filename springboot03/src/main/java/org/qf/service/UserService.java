package org.qf.service;

import org.qf.entity.User1;
import org.qf.utils.ResultVo;

/**
 * 业务层接口
 */
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
    ResultVo addUser(User1 user);

    ResultVo deleteUserById(Integer userId);

    ResultVo updateUser(User1 user);

    ResultVo deleteBatch(Integer[] idList);
}
