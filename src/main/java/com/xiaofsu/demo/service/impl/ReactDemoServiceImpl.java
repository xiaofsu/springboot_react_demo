package com.xiaofsu.demo.service.impl;

import com.xiaofsu.demo.entity.ReactDemo;
import com.xiaofsu.demo.dao.ReactDemoDao;
import com.xiaofsu.demo.service.ReactDemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ReactDemo)表服务实现类
 *
 * @author xiaoFsu
 * @since 2020-05-01 23:40:08
 */
@Service("reactDemoService")
public class ReactDemoServiceImpl implements ReactDemoService {
    @Resource
    private ReactDemoDao reactDemoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReactDemo queryById(Integer id) {
        return this.reactDemoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ReactDemo> queryAllByLimit(int offset, int limit) {
        return this.reactDemoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param reactDemo 实例对象
     * @return 实例对象
     */
    @Override
    public ReactDemo insert(ReactDemo reactDemo) {
        this.reactDemoDao.insert(reactDemo);
        return reactDemo;
    }

    /**
     * 修改数据
     *
     * @param reactDemo 实例对象
     * @return 实例对象
     */
    @Override
    public ReactDemo update(ReactDemo reactDemo) {
        this.reactDemoDao.update(reactDemo);
        return this.queryById(reactDemo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.reactDemoDao.deleteById(id) > 0;
    }
}