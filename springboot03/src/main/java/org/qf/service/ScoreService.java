package org.qf.service;

import org.qf.entity.Score;
import org.qf.utils.ResultVo;

public interface ScoreService {

    /**
     * 查询
     * @param name
     * @return
     */
    public ResultVo showList2(String name, int pageNum);

    /**
     * 添加用户
     * @param score
     * @return
     */
    ResultVo addScore(Score score);

    ResultVo deleteScoreById(Integer id);

    ResultVo updateScore(Score score);
}
