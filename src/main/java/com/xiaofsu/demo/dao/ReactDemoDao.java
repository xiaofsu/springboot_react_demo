package com.xiaofsu.demo.dao;

import com.xiaofsu.demo.entity.ReactDemo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ReactDemo)表数据库访问层
 *
 * @author xiaoFsu
 * @since 2020-05-01 23:40:07
 */

@Mapper
public interface ReactDemoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReactDemo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ReactDemo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param reactDemo 实例对象
     * @return 对象列表
     */
    List<ReactDemo> queryAll(ReactDemo reactDemo);

    /**
     * 新增数据
     *
     * @param reactDemo 实例对象
     * @return 影响行数
     */
    int insert(ReactDemo reactDemo);

    /**
     * 修改数据
     *
     * @param reactDemo 实例对象
     * @return 影响行数
     */
    int update(ReactDemo reactDemo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}