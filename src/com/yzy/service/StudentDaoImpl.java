package com.yzy.service;

import com.yzy.dao.StudentDao;
import com.yzy.entity.Student;
import com.yzy.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author com.yzy
 * @version 1.0
 * @description TODO
 * @date 2023/6/21 17:00
 */
public class StudentDaoImpl implements StudentDao {
    private Connection connection = JDBCUtil.getConnection();

    private String sql;

    private ResultSet resultSet;

    private PreparedStatement preparedStatement;

    @Override
    public int insert(Student student) {
        sql = "insert into student(id,username,password,gender,img) values(?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getUsername());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setString(4, student.getGender());
            preparedStatement.setString(5, student.getImg());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int delete(Integer id) {
        sql = "delete from student where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Student student) {
        Integer id = student.getId();
        String username = student.getUsername();
        String gender = student.getGender();
        String img = student.getImg();

        sql = "update student set username = ? ,gender = ?,img = ? where id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, gender);
            preparedStatement.setString(3, img);
            preparedStatement.setInt(4, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student select(Integer id) {
        sql = "select * from student where id = ?";
        Student student = new Student();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setUsername(resultSet.getString("username"));
                student.setPassword(resultSet.getString("password"));
                student.setGender(resultSet.getString("gender"));
                student.setImg(resultSet.getString("img"));
            }
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Student select(String username) {
        sql = "select * from student where username = ?";
        Student student = new Student();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student.setId(resultSet.getInt("id"));
                student.setUsername(resultSet.getString("username"));
                student.setPassword(resultSet.getString("password"));
                student.setGender(resultSet.getString("gender"));
                student.setImg(resultSet.getString("img"));
            }
            return student;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> selectAll() {
        sql = "select * from student order by id";
        List<Student> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setPassword(resultSet.getString("password"));
                student.setUsername(resultSet.getString("username"));
                student.setImg(resultSet.getString("img"));
                student.setGender(resultSet.getString("gender"));
                list.add(student);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> selectByParam(String param) {
        List<Student> list = new ArrayList<>();
        try {
            sql = "select * from student where id = ? or username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(param));
            preparedStatement.setString(2, param);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(Integer.parseInt((resultSet.getString("id"))));
                student.setUsername(resultSet.getString("username"));
                student.setPassword(resultSet.getString("password"));
                student.setGender(resultSet.getString("gender"));
                student.setImg(resultSet.getString("img"));
                list.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
