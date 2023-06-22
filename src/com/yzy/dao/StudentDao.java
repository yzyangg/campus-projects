package com.yzy.dao;

import com.yzy.entity.Student;

import java.util.List;

/**
 * @author com.yzy
 * @version 1.0
 * @description TODO
 * @date 2023/6/21 16:59
 */
public interface StudentDao {

    int insert(Student student);

    int delete(Integer id);

    int update(Student student);

    Student select(Integer id);

    Student select(String username);

    List<Student> selectAll();

    List<Student> selectByID(String param);


    List<Student> selectByName(String param);
}
