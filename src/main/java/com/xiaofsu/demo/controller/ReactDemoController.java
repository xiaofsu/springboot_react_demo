package com.xiaofsu.demo.controller;

import com.xiaofsu.demo.entity.ReactDemo;
import com.xiaofsu.demo.service.ReactDemoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ReactDemo)表控制层
 *
 * @author xiaoFsu
 * @since 2020-05-01 23:40:08
 */
@RestController
@RequestMapping("reactDemo")
public class ReactDemoController {
    /**
     * 服务对象
     */
    @Resource
    private ReactDemoService reactDemoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ReactDemo selectOne(Integer id) {
        return this.reactDemoService.queryById(id);
    }

    @GetMapping("selectList")
    public List<ReactDemo> selectList(Integer offset, Integer limit) {
        return this.reactDemoService.queryAllByLimit(offset,limit);
    }

}