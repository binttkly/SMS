package org.qf.dao;

import org.apache.ibatis.annotations.Mapper;
import org.qf.entity.Score;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface ScoreDao {
    /**
     * 查询操作
     * @return
     */
    public List<Score> showList2(String name);

    /**
     * 根据用户名查询用户
     *
     */
    Score getScoreByName(String name);

    /**
     * 添加用户
     */
    void addScore(Score score);

    //    根据id删除用户
    void deleteScoreById(Integer id);

    //    修改用户
    void updateScore(Score score);

}
