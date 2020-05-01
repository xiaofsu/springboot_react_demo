package com.xiaofsu.demo.entity;

import java.io.Serializable;

/**
 * (ReactDemo)实体类
 *
 * @author xiaoFsu
 * @since 2020-05-01 23:40:06
 */
public class ReactDemo implements Serializable {
    private static final long serialVersionUID = -88446555112871932L;
    
    private Integer id;
    
    private String name;
    
    private String sex;
    
    private Integer age;
    
    private String test1;
    
    private String test2;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

}