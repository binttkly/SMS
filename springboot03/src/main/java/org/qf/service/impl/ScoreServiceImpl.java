package org.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.qf.dao.ScoreDao;
import org.qf.entity.Score;
import org.qf.service.ScoreService;
import org.qf.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    //查询
    @Override
    public ResultVo showList2(String studentName, int pageNum) {
        //设置页面容量
        PageHelper.startPage(pageNum,5);
        List<Score> list = scoreDao.showList2(studentName);
        PageInfo<Score> pageInfo=new PageInfo<Score>(list);
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
    public ResultVo addScore(Score score) {
        Score selectScore = scoreDao.getScoreByName(score.getName());
        if(selectScore==null){
            //可以添加
            scoreDao.addScore(score);
            return new ResultVo(502,"添加成功",null);
        }else{
            //给出错误提示
            return new ResultVo(501,"用户名已存在",null);
        }
    }

    @Override
    public ResultVo deleteScoreById(Integer id) {
        scoreDao.deleteScoreById(id);
        return new ResultVo(200,"删除成功",null);
    }

    @Override
    public ResultVo updateScore(Score score) {
        scoreDao.updateScore(score);
        return new ResultVo(200,"编辑成功",null);
    }
}
