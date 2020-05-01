package com.xiaofsu.demo.service;

import com.xiaofsu.demo.entity.ReactDemo;
import java.util.List;

/**
 * (ReactDemo)表服务接口
 *
 * @author xiaoFsu
 * @since 2020-05-01 23:40:07
 */
public interface ReactDemoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReactDemo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReactDemo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param reactDemo 实例对象
     * @return 实例对象
     */
    ReactDemo insert(ReactDemo reactDemo);

    /**
     * 修改数据
     *
     * @param reactDemo 实例对象
     * @return 实例对象
     */
    ReactDemo update(ReactDemo reactDemo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}